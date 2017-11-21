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

import br.com.futeboldospais.futeboldospais.model.Atualizacao;

import static org.junit.Assert.assertEquals;

/**
 * Created by ThirdSystem on 06/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class VerificarAtualizacaoInstrumentedTest {

    private int verificarAtualizacao;
    private Context appContext;

    private class StatusReceiver extends ResultReceiver {

        private StatusReceiver(Handler handler) {
            super(handler);
        }

        @Override
        public void onReceiveResult(int resultCode, Bundle dados) {
            super.onReceiveResult(resultCode, dados);
            if (resultCode == Atualizacao.RESULT_CODE_VERIFICAR_ATUALIZACAO) {

                Log.d("teste", "status atualizacao teste: " + String.valueOf(dados.getInt(Atualizacao.VERIFICAR_ATUALIZACAO)));
                verificarAtualizacao = dados.getInt(Atualizacao.VERIFICAR_ATUALIZACAO);
            }
        }
    }

    @Before
    public void iniciaServico() {

        appContext = InstrumentationRegistry.getTargetContext();

        Intent intentService = new Intent(appContext, ServicoAtualizacao.class);
        intentService.putExtra(Atualizacao.RECEPTOR, new StatusReceiver(new Handler(Looper.getMainLooper())));
        appContext.startService(intentService);
    }

    /**
     * @author Daniel Almeida
     * Método que simula o teste de verificação da não existencia de atualização
     * ----------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 45 da classe
     * ConfiguracaoService manter o valor do parâmetro:
     * //String json = ObtemJsonDeConfiguracao.comParametrosASeremAlterados(1);
     */
    @Test
    public void testaStatusAtualizacaoSemanalInexistente() throws Exception{

        String teste = null;

        Thread.sleep(500);

        if (verificarAtualizacao == 2) {
            teste = "Existe atualização";
        } else if (verificarAtualizacao == 1) {
            teste = "Não existe atualizacao";
        } else if (verificarAtualizacao == 0) {
            teste = "Erro ao verificar atualização";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Não existe atualização", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula o teste de uma verificação de atualizacao semanal ao
     * trocar o valor do atributo versaoAtualizacao no servidor
     * ----------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 45 da classe
     * ConfiguracaoService e incrementar o valor do parâmetro:
     * //String json = ObtemJsonDeConfiguracao.comParametrosASeremAlterados(1);
     * ----------------------------------------------------------------------------
     * Exemplo:
     * Valor atual parâmetro = 1
     * Novo valor parâmetro = 2
     * //String json = ObtemJsonDeConfiguracao.comParametrosASeremAlterados(2);
     */
    @Ignore
    public void testaStatusAtualizacaoSemanalExistente() throws Exception{

        String teste = null;

        Thread.sleep(500);

        if (verificarAtualizacao == 2) {
            teste = "Existe atualização";
        } else if (verificarAtualizacao == 1) {
            teste = "Não existe atualizacao";
        } else if (verificarAtualizacao == 0) {
            teste = "Erro ao verificar atualização";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Existe atualização", teste);
    }

    /**
     * @author Daniel Almeida
     * Método que simula o teste de uma verificação de atualizacao com erro no
     * arquivo de configuração do servidor
     * ---------------------------------------------------------------------------
     * Para realizar este teste é necessário descomentar a linha 46 da classe
     * ConfiguracaoService:
     * //String json = ObtemJsonDeConfiguracao.comValorDeAtributoIncorreto();
     */
    @Ignore
    public void testaStatusAtualizacaoComErroNoArquivoDeConfiguracao() throws Exception{

        String teste = null;

        Thread.sleep(500);

        if (verificarAtualizacao == 2) {
            teste = "Existe atualização";
        } else if (verificarAtualizacao == 1) {
            teste = "Não existe atualizacao";
        } else if (verificarAtualizacao == 0) {
            teste = "Erro ao verificar atualização";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Erro ao verificar atualização", teste);
    }
}
