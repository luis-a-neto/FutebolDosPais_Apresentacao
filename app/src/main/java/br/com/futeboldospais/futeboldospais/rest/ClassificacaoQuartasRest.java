package br.com.futeboldospais.futeboldospais.rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ThirdSystem on 20/11/2017.
 */

public class ClassificacaoQuartasRest {

    /**
     * @author Denilson Araújo on 25/10/2017
     * @modifield Pâmela Fidelis and Vinicius Lopes on 28/10/2017
     *
     */
    public String getQuartasFinais(String urlBase) throws Exception {

        String rs;

        String url = urlBase + "classificacao-4as-finais.txt";
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10000, TimeUnit.MILLISECONDS).readTimeout(5000,
                TimeUnit.MILLISECONDS).writeTimeout(5000, TimeUnit.MILLISECONDS).build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();

        if(client.connectTimeoutMillis() <= 10000 && client.readTimeoutMillis() <= 5000) {
            rs = new String(response.body().bytes(), "ISO-8859-1");
        }
        else{
            rs = null;
        }

        return rs;
    }
}
