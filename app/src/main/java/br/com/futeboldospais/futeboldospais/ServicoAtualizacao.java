package br.com.futeboldospais.futeboldospais;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.util.Log;

import br.com.futeboldospais.futeboldospais.model.Atualizacao;
import br.com.futeboldospais.futeboldospais.service.AtualizacaoService;
import br.com.futeboldospais.futeboldospais.util.GerenciadorDeConectividade;

/**
 * Created by ThirdSystem on 12/10/2017.
 */

public class ServicoAtualizacao extends IntentService {

    private AtualizacaoService atualizacaoService;
    private ResultReceiver resultReceiver;
    private Bundle dados;


    public ServicoAtualizacao() {
        super("AtualizationServicePlus");
        Log.d("teste", "1 - fui iniciado");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public ServicoAtualizacao(String name) {
        super(name);
        Log.d("teste", "1 - fui iniciado");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("teste", "1 - fui iniciado aqui");

        boolean status;
        int verificarAtualizacao;
        int atualizacaoStatus;
        int conexao;

        if (intent != null) {
            resultReceiver = intent.getParcelableExtra(Atualizacao.RECEPTOR);

            dados = new Bundle();

            if (GerenciadorDeConectividade.isConnected(getBaseContext())) {

                conexao = 1;
                dados.putInt(Atualizacao.STATUS_CONEXAO, conexao);
                resultReceiver.send(Atualizacao.RESULT_CODE_STATUS_CONEXAO, dados);

                atualizacaoService = new AtualizacaoService(getBaseContext());
                Log.d("teste", "1 - instanciou atualizacaoService");

                verificarAtualizacao = atualizacaoService.verificarAtualizacao();

                dados.putInt(Atualizacao.VERIFICAR_ATUALIZACAO, verificarAtualizacao);
                resultReceiver.send(Atualizacao.RESULT_CODE_VERIFICAR_ATUALIZACAO, dados);

                if (verificarAtualizacao == 2) {
                    status = atualizacaoService.executarAtualizacaoPorTipo();

                    if (status) {
                        atualizacaoStatus = 1;
                    } else {
                        atualizacaoStatus = 0;
                    }

                    dados.putInt(Atualizacao.STATUS_ATUALIZACAO, atualizacaoStatus);
                    resultReceiver.send(Atualizacao.RESULT_CODE_STATUS_ATUALIZACAO, dados);
                }
            } else {
                conexao = 0;
                dados.putInt(Atualizacao.STATUS_CONEXAO, conexao);
                resultReceiver.send(Atualizacao.RESULT_CODE_STATUS_CONEXAO, dados);
            }
        }
        stopSelf();
        Log.d("teste", "serviço auto destruido");
    }

}
