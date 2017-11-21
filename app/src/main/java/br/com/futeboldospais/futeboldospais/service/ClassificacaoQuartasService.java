package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.ClassificacaoQuartasDAO;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;
import br.com.futeboldospais.futeboldospais.rest.ClassificacaoQuartasRest;

/**
 * Created by ThirdSystem on 20/11/2017.
 */

public class ClassificacaoQuartasService {

    ClassificacaoQuartasDAO dao;
    ClassificacaoQuartasRest classificacaoQuartasRest;

    public ClassificacaoQuartasService() {
        dao = new ClassificacaoQuartasDAO();
        classificacaoQuartasRest =  new ClassificacaoQuartasRest();
    }

    /**
     * @author Denilson Araujo on 31/10/2017.
     */
    public List<ClassificacaoQuartas> getClassificacaoQuartas(int campeonatoAno) throws Exception {

        List<ClassificacaoQuartas> timesClassificados;

        //String json = classificacaoQuartasRest.getQuartasFinais(ConfiguracaoService.urlBase(campeonatoAno));

        String json =
                "[" +
                        "{" +
                        "  \"categoria\": \"Master\"," +
                        "  \"grupo\":\"Principal\"," +
                        "  \"listaClassificacao\": [" +
                            "{" +
                                "  \"posicao\": \"2\"," +
                                "  \"equipe\": \"Ferroviaria\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"1\"," +
                                "  \"equipe\": \"Red-Bull\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"3\"," +
                                "  \"equipe\": \"Linense\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"4\"," +
                                "  \"equipe\": \"Mirassol\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }" +
                            " ]" +
                        " }," +
                        "{" +
                        "  \"categoria\": \"Master\"," +
                        "  \"grupo\":\"Repescagem\"," +
                        "  \"listaClassificacao\": [" +
                            "{" +
                                "  \"posicao\": \"3\"," +
                                "  \"equipe\": \"Ponte-Preta\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"2\"," +
                                "  \"equipe\": \"Sao-Bento\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"1\"," +
                                "  \"equipe\": \"Novorizontino\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"4\"," +
                                "  \"equipe\": \"Botafogo\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }" +
                            " ]" +
                        " }," +
                        "{" +
                        "  \"categoria\": \"Senior\"," +
                        "  \"grupo\":\"Principal\"," +
                        "  \"listaClassificacao\": [" +
                            "{" +
                                "  \"posicao\": \"4\"," +
                                "  \"equipe\": \"Red-Bull\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"1\"," +
                                "  \"equipe\": \"Mirassol\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"3\"," +
                                "  \"equipe\": \"Ferroviaria\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"2\"," +
                                "  \"equipe\": \"Linense\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }" +
                            " ]" +
                        " }," +
                        "{" +
                        "  \"categoria\": \"Senior\"," +
                        "  \"grupo\":\"Repescagem\"," +
                        "  \"listaClassificacao\": [" +
                            "{" +
                                "  \"posicao\": \"2\"," +
                                "  \"equipe\": \"Sao-Bento\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"1\"," +
                                "  \"equipe\": \"Ponte-Preta\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"3\"," +
                                "  \"equipe\": \"Novorizontino\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }," +
                                "{" +
                                "  \"posicao\": \"4\"," +
                                "  \"equipe\": \"Botafogo\"," +
                                "  \"pontosGanhos\": \"74\"," +
                                "  \"jogos\": \"31\"," +
                                "  \"vitorias\": \"17\"," +
                                "  \"empates\": \"9\"," +
                                "  \"derrotas\": \"5\"," +
                                "  \"golsPro\": \"72\"," +
                                "  \"golsContra\": \"45\"," +
                                "  \"saldoGols\": \"27\"" +
                                " }" +
                            " ]" +
                        " }" +
                        "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;

        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Type listType = new TypeToken<List<ClassificacaoQuartas>>() {}.getType();
        timesClassificados = gson.fromJson(jsonArray.toString(), listType);

        return timesClassificados;
    }

    /**
     * @author Denilson Aráujo on 31/10/2017.
     **/
    public long inserirDados(SQLiteDatabase bd, List<ClassificacaoQuartas> lista) {
        return dao.inserirDados(bd, lista);
    }

    /**
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     * @param bd Conexão de gravação passada para a camada dao
     */
    public void deletarDados(SQLiteDatabase bd){
        dao.deletarDados(bd);
    }

    /**
     * @param context da aplicacao e tambem o nome daquipe
     * @return objeto tipo Classificacao com os dados da equipe
     * @author Pâmela Fidelis
     */

    public Classificacao[] listarQuartasPorCategoriaGrupo(Context context, String categoria, String grupo) {
        return dao.listarDadosPorCategoriaGrupo(context, categoria, grupo);
    }

    public String buscarEquipeNaPosicao(Context context, String categoria, String grupo, int posicao){
        return dao.buscarEquipeNaPosicao(context, categoria, grupo, posicao);
    }
}
