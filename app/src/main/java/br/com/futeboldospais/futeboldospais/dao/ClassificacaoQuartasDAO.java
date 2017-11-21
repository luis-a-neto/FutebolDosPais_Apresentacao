package br.com.futeboldospais.futeboldospais.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;

/**
 * Created by ThirdSystem on 20/11/2017.
 */

public class ClassificacaoQuartasDAO {

    /**
     * @author Denilson Aráujo on 31/10/2017.
     */
    public long inserirDados(SQLiteDatabase bd, List<ClassificacaoQuartas> lista) {

        ContentValues valores = new ContentValues();

        long id = -1;

        for (ClassificacaoQuartas classificacaoQuartas : lista) {

            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_CATEGORIA, classificacaoQuartas.getCategoria());
            valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GRUPO, classificacaoQuartas.getGrupo());
            for (Classificacao classificacao : classificacaoQuartas.getListaClassificacao()) {
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EQUIPE, classificacao.getEquipe());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_PONTOS_GANHOS, classificacao.getPontosGanhos());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_JOGOS, classificacao.getJogos());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_VITORIAS, classificacao.getVitorias());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EMPATES, classificacao.getEmpates());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_DERROTAS, classificacao.getDerrotas());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GOLS_PRO, classificacao.getGolsPro());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GOLS_CONTRA, classificacao.getGolsContra());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_SALDO_GOLS, classificacao.getSaldoGols());
                valores.put(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_POSICAO, classificacao.getPosicao());
                id = bd.insert(BancoDados.Tabela.TABELA_CLASSIFICACAO_QUARTAS, null, valores);
            }

        }
        return id;
    }

    /**
     * @author Denilson Aráujo on 25/10/2017
     */
    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_CLASSIFICACAO_QUARTAS, null, null);
    }

    /**
     * @param context Contexto da aplicação passado para obter conexão de leitura com o banco de dados e as equipes clasificadas de acordo com sua categoria e grupo
     * @return Retorna um objeto do tipo Classificacao de acordo com os parâmetros passaods
     * @author Pâmela Fidelis on 28/10/2017
     * Este metodo serve para buscar as equipes clasificadas de acordo com sua categoria e grupo
     */
    public Classificacao[] listarDadosPorCategoriaGrupo(Context context, String categoria, String grupo) {
        SQLiteDatabase db = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        Cursor c = null;
        Classificacao time;

        ArrayList<Classificacao> classificacaoArrayList = new ArrayList<>();
        Classificacao[] times;

        grupo = Character.toString(grupo.charAt(0)).toUpperCase()+grupo.substring(1);
        categoria = Character.toString(categoria.charAt(0)).toUpperCase()+categoria.substring(1);

        try {
            String[] selectColunasFrom = {
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EQUIPE,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_POSICAO,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_PONTOS_GANHOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_JOGOS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_VITORIAS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_SALDO_GOLS,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_CATEGORIA,
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GRUPO


            };

            String where =
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_CATEGORIA + " = ?"
                            + " AND " + BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GRUPO + " = ?";

            String[] valorWhere =
                    { categoria,grupo};

            c = db.query(BancoDados.Tabela.TABELA_CLASSIFICACAO_QUARTAS,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            Log.i("dao",categoria);
            Log.i("dao",grupo);

            if (c.getCount() != 0) {
                while (c.moveToNext()) {
//                    if(String.valueOf(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GRUPO))).toLowerCase().equals(grupo) &&
//                    String.valueOf(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_CATEGORIA))).toLowerCase().equals(categoria)
//                            ){
                        time = new Classificacao();
                        time.setEquipe(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EQUIPE)));
                        time.setPosicao(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_POSICAO)));
                        time.setPontosGanhos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_PONTOS_GANHOS)));
                        time.setJogos(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_JOGOS)));
                        time.setVitorias(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_VITORIAS)));
                        time.setSaldoGols(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_SALDO_GOLS)));
                        classificacaoArrayList.add(time);
//                    }


                }
                times = classificacaoArrayList.toArray(new Classificacao[0]);
            } else {
                times = new Classificacao[0];
            }
        } catch (Exception e) {
            times = new Classificacao[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }
        Log.i("times: ", Arrays.toString(times));
        return times;
    }

    public String buscarEquipeNaPosicao(Context context, String categoria, String grupo, int posicao) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoAplicacao(context);
        String equipe = null;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EQUIPE};

            String where =
                    BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_CATEGORIA + " = ?"
                            + " AND " + BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_GRUPO + " = ?"
                            + " AND " + BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_POSICAO + " = ?";

            String[] valorWhere =
                    { categoria, grupo, String.valueOf(posicao) };

            c = bd.query(BancoDados.Tabela.TABELA_CLASSIFICACAO_QUARTAS,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );


            if (c.moveToFirst()) {
                equipe = c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_CLASSIFICACAO_QUARTAS_EQUIPE));
            } else {
                equipe = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return equipe;
    }
}
