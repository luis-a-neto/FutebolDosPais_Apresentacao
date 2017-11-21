package br.com.futeboldospais.futeboldospais;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.model.Atualizacao;
import br.com.futeboldospais.futeboldospais.service.ArtilhariaService;

import static org.junit.Assert.assertEquals;

/**
 * Created by ThirdSystem on 06/11/2017.
 * Classe de testes de atualização utilizando o critério de equivalencia,
 * levando em consideração que um arquivo json incorreto impacta em toda
 * a atualização de dados do aplicativo sem exceção
 * ----------------------------------------------------------------------------
 * Importante:
 *
 * 1º Caso métodos get das classes Service estejam recebendo o arquivo json
 * do servidor, será necessário que o dispositivo esteja conectado à internet
 * para executar os métodos de teste desta classe corretamente
 *
 * 2º Para que a simulação de atualização funcione, é necessário descomentar
 * a linha 45 da classe ConfiguracaoService e incrementar o valor do parâmetro:
 * //String json = ObtemJsonDeConfiguracao.comParametrosASeremAlterados(1);
 * ----------------------------------------------------------------------------
 * Exemplo:
 * Valor atual parâmetro = 1
 * Novo valor parâmetro = 2
 * //String json = ObtemJsonDeConfiguracao.comParametrosASeremAlterados(2);
 *
 * Ou utilizar o arquivo de configuração diretamente do servidor, alterando o
 * valor do atributo versaoAtualizacao via conexão ftp (utilizar esta opção
 * somente em ambiente de testes)
 */

@RunWith(AndroidJUnit4.class)
public class AtualizacaoInstrumentedTest {

    private ArtilhariaService artilhariaService;
    private int statusAtualizacao;
    private Context appContext;

    private class StatusReceiver extends ResultReceiver {

        private StatusReceiver(Handler handler) {
            super(handler);
        }

        @Override
        public void onReceiveResult(int resultCode, Bundle dados) {
            super.onReceiveResult(resultCode, dados);
            if (resultCode == Atualizacao.RESULT_CODE_STATUS_ATUALIZACAO) {

                Log.d("teste", "status conexao teste: " + String.valueOf(dados.getInt(Atualizacao.STATUS_ATUALIZACAO)));
                statusAtualizacao = dados.getInt(Atualizacao.STATUS_ATUALIZACAO);
            }
        }
    }

    @Before
    public void iniciaServico() {

        appContext = InstrumentationRegistry.getTargetContext();

        artilhariaService = new ArtilhariaService();

        Intent intentService = new Intent(appContext, ServicoAtualizacao.class);
        intentService.putExtra(Atualizacao.RECEPTOR, new StatusReceiver(new Handler(Looper.getMainLooper())));
        appContext.startService(intentService);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que não contém erros no conteúdo
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 50 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.queNaoContemErros();
     */
    @Ignore
    public void testaAtualizacaoComArquivoJsonQueNaoContemErro() throws Exception{

        String teste = null;

        Thread.sleep(20000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Atualização realizada com sucesso", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que não contém objetos em seu conteúdo
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 51 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.comNenhumObjeto();
     */
    @Test
    public void testaAtualizacaoComArquivoJsonSemObjetos() throws Exception{

        String teste = null;
        Artilharia[] listaArtilharia;

        Thread.sleep(20000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Atualização realizada com sucesso", teste);

        listaArtilharia = artilhariaService.listarDadosPorCategoria(appContext, "Master");
        assertEquals(0, listaArtilharia.length);

        listaArtilharia = artilhariaService.listarDadosPorCategoria(appContext, "Senior");
        assertEquals(0, listaArtilharia.length);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que contém um erro após o último objeto
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 52 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.comVirgulaNoUltimoObjeto();
     */
    @Ignore
    public void testaAtualizacaoComArquivoJsonComVirgulaNoFinal() throws Exception{

        String teste = null;

        Thread.sleep(3000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Falha ao tentar atualizar", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que contém um nome de atributo incorreto em seu conteúdo
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 53 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.comAtributoIncorreto();
     */
    @Ignore
    public void testaAtualizacaoComArquivoJsonComAtributoIncorreto() throws Exception{

        String teste = null;

        Thread.sleep(3000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Falha ao tentar atualizar", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que contém um atributo com valor diferente do esperado:
     * Atributo: gols, Esperado: inteiro, Recebido: texto
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 54 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.comValorDeAtributoIncorreto();
     */
    @Ignore
    public void testaAtualizacaoComArquivoJsonComValorDeAtributoIncorreto() throws Exception{

        String teste = null;

        Thread.sleep(3000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Falha ao tentar atualizar", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula a execução de uma atualização recebendo um arquivo json
     * que não contenha nenhum caractere em seu conteúdo
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 55 da classe
     * ArtilhariaService:
     * //String json = ObtemJsonDeArtilharia.comStringVazia();
     */
    @Ignore
    public void testaAtualizacaoComArquivoJsonComConteudoEmBranco() throws Exception{

        String teste = null;

        Thread.sleep(3000);

        if (statusAtualizacao == 1) {
            teste = "Atualização realizada com sucesso";
        } else if (statusAtualizacao == 0) {
            teste = "Falha ao tentar atualizar";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Falha ao tentar atualizar", teste);
    }
}
