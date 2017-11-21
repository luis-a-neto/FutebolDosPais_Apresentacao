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
 * Created by ThirdSystem on 05/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class StatusDaConexaoNaAtualizacaoInstrumentedTest {

    private int statusConexao;
    private Context appContext;

    private class StatusReceiver extends ResultReceiver {

        private StatusReceiver(Handler handler) {
            super(handler);
        }

        @Override
        public void onReceiveResult(int resultCode, Bundle dados) {
            super.onReceiveResult(resultCode, dados);
            if (resultCode == Atualizacao.RESULT_CODE_STATUS_CONEXAO) {

                Log.d("teste", "status conexao teste: " + String.valueOf(dados.getInt(Atualizacao.STATUS_CONEXAO)));
                statusConexao = dados.getInt(Atualizacao.STATUS_CONEXAO);
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
     * @throws Exception
     * @author Daniel Almeida
     * Método que testa resultado ao tentar atualizar sem que o dispositivo
     * esteja devidamente conectado à internet
     * Para realizar este teste é necessário que o dispositivo deve estar
     * com a rede desativada
     */
    @Test
    public void testaAtualizacaoEmDispositivoSemInternet() throws Exception {

        String teste = null;

        Thread.sleep(500);

        if (statusConexao == 1) {
            teste = "Dispositivo conectado à internet";
        } else if (statusConexao == 0) {
            teste = "Dispositivo não conectado à internet";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Dispositivo não conectado à internet", teste);
    }

    /**
     * @throws Exception
     * @author Daniel Almeida
     * Método que testa resultado ao tentar atualizar com o dispositivo
     * conectado a internet
     * Para realizar este teste é necessário que o dispositivo esteja
     * conectado à internet
     */
    @Ignore
    public void testaAtualizacaoEmDispositivoComInternet() throws Exception {

        String teste = null;

        Thread.sleep(500);

        if (statusConexao == 1) {
            teste = "Dispositivo conectado à internet";
        } else if (statusConexao == 0) {
            teste = "Dispositivo não conectado à internet";
        } else {
            teste = "Teste falhou";
        }

        assertEquals("Dispositivo conectado à internet", teste);
    }
}
