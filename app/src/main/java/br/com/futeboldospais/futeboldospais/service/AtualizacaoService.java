package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.dao.BancoDadosHelper;

/**
 * Created by Daniel Almeida on 09/10/2017.
 */

public class AtualizacaoService extends AtualizacaoServiceInterface{

    private Context context;

    public AtualizacaoService(Context context) {
        super();
        this.context = context;
    }

    /**
     * @author Daniel Almeida
     * Método para buscar a versão de configuração no servidor e verificar
     * se é a primeira atualização de dados, se existe uma atualização anual,
     * se existe uma atualização semanal ou se não existe atualização
     * ----------------------------------------------------------------------
     * Critério saída:
     * int verificarAtualizacao = 2 - Existe um dos três tipos de atualização acima citados;
     * int verificarAtualizacao = 1 = Não existe atualização a ser executada;
     * int verificarAtualizacao = 0 - Ocorreu um erro ao verificar atualizações.
     *
     * @return Inteiro que demonstra se existe atualização ou não
     */
    @Override
    public int verificarAtualizacao() {
        Log.d("teste", "entrou no verificar atualização");

        int verificarAtualizacao;

        try {
            configuracaoService = new ConfiguracaoService();
            Log.d("teste", "1 - instanciou configuracao service");
            atualizacao.setConfiguracaoServidor(configuracaoService.getConfiguracaoServidor());
            Log.d("teste", atualizacao.getConfiguracaoServidor().toString());

            atualizacao.setVersaoLocal(configuracaoService.getVersaoLocal(context));
            atualizacao.setCampeonatoAnoLocal(configuracaoService.getCampeonatoAnoLocal(context));
            Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
            //atualizacao.setVersaoServidor(atualizacao.getConfiguracaoServidor().getVersao());
            Log.d("teste", "versao atual: " + atualizacao.getConfiguracaoServidor().getVersaoAtualizacao());
            Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
            //atualizacao.setCampeonatoAnoServidor(atualizacao.getConfiguracaoServidor().getCampeonatoAno());
            Log.d("teste", "campeonato ano servidor: " + atualizacao.getConfiguracaoServidor().getCampeonatoAno());
            Log.d("teste", "ultima atualizacao: " + configuracaoService.getUltimaAtualizacao(context));

            if (atualizacao.getCampeonatoAnoLocal() == -1) {
                atualizacao.setTipoAtualizacao(1);
                verificarAtualizacao = 2;
            } else if (atualizacao.getCampeonatoAnoLocal() != atualizacao.getConfiguracaoServidor().getCampeonatoAno()) {
                atualizacao.setTipoAtualizacao(2);
                verificarAtualizacao = 2;
            } else if (atualizacao.getVersaoLocal() != atualizacao.getConfiguracaoServidor().getVersaoAtualizacao()) {
                atualizacao.setTipoAtualizacao(3);
                verificarAtualizacao = 2;
            } else {
                atualizacao.setTipoAtualizacao(0);
                verificarAtualizacao = 1;
            }

            Log.d("teste", "tipo atualizacao: " + atualizacao.getTipoAtualizacao());
        } catch (Exception e) {
            verificarAtualizacao = 0;
        }

        return verificarAtualizacao;
    }

    /**
     * @author Daniel Almeida
     * Método que pode executar o método atualizarDados de acordo com o valor
     * setado no atributo inteiro tipoAtualizacao da classe Atualizacao pelo
     * método verificarAtualizacao
     * -----------------------------------------------------------------------
     * Entradas verificadas:
     * tipoAtualizacao = 1 - Primeira atualização de dados do aplicativo;
     * tipoAtualizacao = 2 - Atualização de dados anual do aplicativo;
     * tipoAtualizacao = 3 - Atualização semanal de dados do aplicativo.
     * ------------------------------------------------------------------------
     * Saida:
     * True - Dados foram atualizados com sucesso;
     * False - Ocorreu uma falha ao executar o método atualizarDados.
     *
     * @return Verdeiro ou falso
     */
    @Override
    public boolean executarAtualizacaoPorTipo() {
        Log.d("teste", "1 - entrou no executar atualizacao");

        boolean atualizacaoStatus = false;

        try {

            if (atualizacao.getTipoAtualizacao() == 1) {
                configuracaoServidor = atualizacao.getConfiguracaoServidor();
                atualizacaoStatus = atualizarDados(atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou primeira atualizacao");
            } else if (atualizacao.getTipoAtualizacao() == 2) {
                configuracaoServidor = atualizacao.getConfiguracaoServidor();
                atualizacaoStatus = atualizarDados(atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou atualizacao anual");
            } else if (atualizacao.getTipoAtualizacao() == 3) {
                configuracaoServidor = atualizacao.getConfiguracaoServidor();
                atualizacaoStatus = atualizarDados(atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "tipo att: " + atualizacao.getTipoAtualizacao());
                Log.d("teste", "versao local: " + atualizacao.getVersaoLocal());
                Log.d("teste", "campeonato ano local: " + atualizacao.getCampeonatoAnoLocal());
                Log.d("teste", "executou atualizacao semanal");
            } else {
                Log.d("teste", "nao executou atualizacao");
            }

        } catch (Exception e) {
            atualizacaoStatus = false;
        }

        return atualizacaoStatus;
    }

    /**
     * @author Daniel Almeida
     * Método que realiza a atualização dos dados do aplicativo
     *
     * @param campeonatoAnoLocal Inteiro que demonstra o ano do campeonato atual no banco local
     *
     * método verificarAtualizacao e passada através do método executarAtualizacaoPorTipo
     * ------------------------------------------------------------
     * Saida:
     * True - Dados atualizados com sucesso
     * False - Erro ao tentar atualizar dados
     *
     * @return Verdadeiro ou False
     * @throws Exception Exceção ocorrida na tentativa de atualzação
     */
    @Override
    public boolean atualizarDados(int campeonatoAnoLocal) throws Exception {
        Log.d("teste", "entrou no atualizar dados");

        boolean atualizacaoStatus = false;

        SQLiteDatabase bd = null;
        Log.d("teste", "criou sqlitehelper");

        try {
            distintivoService = new DistintivoService();
            classificacaoService = new ClassificacaoService();
            artilhariaService = new ArtilhariaService();
            cartaoService = new CartaoService();
            suspensaoService = new SuspensaoService();
            resultadoService = new ResultadoService();
            classificacaoQuartasService = new ClassificacaoQuartasService();
            Log.d("teste", "instanciou os services");

            bd = BancoDadosHelper.FabricaDeConexao.getConexaoServico(context);
            Log.d("teste", "recebeu uma conexao de servico");

            listaClassificacao = classificacaoService.getClassificacao(configuracaoServidor.getCampeonatoAno());
            listaArtilharia = artilhariaService.getArtilharia(configuracaoServidor.getCampeonatoAno());
            listaCartaoAmarelo = cartaoService.getCartaoAmarelo(configuracaoServidor.getCampeonatoAno());
            listaCartaoVermelho = cartaoService.getCartaoVermelho(configuracaoServidor.getCampeonatoAno());
            listaSuspensao = suspensaoService.getSuspensao(configuracaoServidor.getCampeonatoAno());
            listaResutado = resultadoService.getResultado(configuracaoServidor.getCampeonatoAno());
            listaJogo = resultadoService.getJogo(configuracaoServidor.getCampeonatoAno());
            listaClassificacaoQuartas = classificacaoQuartasService.getClassificacaoQuartas(configuracaoServidor.getCampeonatoAno());
            Log.d("teste", "carregou as listas");

            distintivoService.atualizarDistintivos(context, configuracaoServidor.getCampeonatoAno(), campeonatoAnoLocal, listaClassificacao);

            Log.d("teste", "deu pau");

            bd.beginTransaction();
            Log.d("teste", "iniciou a transacao");

            classificacaoService.deletarDados(bd);
            artilhariaService.deletarDados(bd);
            cartaoService.deletarDados(bd);
            suspensaoService.deletarDados(bd);
            resultadoService.deletarDados(bd);
            classificacaoQuartasService.deletarDados(bd);
            Log.d("teste", "deletou dados antigos");
            classificacaoService.inserirDados(bd, listaClassificacao);
            artilhariaService.inserirDados(bd, listaArtilharia);
            cartaoService.inserirDados(bd, listaCartaoAmarelo, listaCartaoVermelho);
            suspensaoService.inserirDados(bd, listaSuspensao);
            resultadoService.inserirDados(bd, listaResutado, listaJogo);
            classificacaoQuartasService.inserirDados(bd, listaClassificacaoQuartas);
            Log.d("teste", "inseriu novos dados");

            configuracaoService.atualizarVersaoLocal(bd, configuracaoServidor, campeonatoAnoLocal);
            Log.d("teste", "atualizou a versao");

            bd.setTransactionSuccessful();
            Log.d("teste", "1 - deu commit");

            atualizacaoStatus = true;

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (campeonatoAnoLocal == -1) {
                    distintivoService.excluirImagemNoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao);
                } else if (campeonatoAnoLocal != configuracaoServidor.getCampeonatoAno()) {
                    distintivoService.excluirImagemNoArmazenamentoInterno(distintivoService.getDiretorio(), listaClassificacao);
                }
            } catch (Exception ex) {
                atualizacaoStatus = false;
            }
            atualizacaoStatus = false;
            Log.d("teste", " 2 - transacao falhou");
        } finally {
            if (bd != null) {
                bd.endTransaction();
                Log.d("teste", "1 - finalizou transacao com sucesso, 2 - deu rollback");
            }
        }
        return atualizacaoStatus;
    }
}
