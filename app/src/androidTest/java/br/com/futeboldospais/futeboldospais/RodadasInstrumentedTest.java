package br.com.futeboldospais.futeboldospais;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;

import static org.junit.Assert.assertEquals;

/**
 * Created by ThirdSystem on 15/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class RodadasInstrumentedTest {

    private Context appContext;
    private ResultadoService resultadoService;

    @Before
    public void setContext() {
        appContext = InstrumentationRegistry.getTargetContext();
        resultadoService = new ResultadoService();
    }

    @Test
    public void testaUltimaRodada() {

        assertEquals(25, resultadoService.listarDadosRodadaAtual(appContext));
    }

    @Test
    public void testaUrlSumula() {

        int position = 0;

        Resultado[] listaResultado = new Resultado[1];
        listaResultado[0] = new Resultado();
        listaResultado[0].setData("23/09/2017");
        listaResultado[0].setHorario("08:30");
        listaResultado[0].setCategoria("Master");

        String data = listaResultado[position].getData();
        String hora = listaResultado[position].getHorario();
        String categoria = listaResultado[position].getCategoria();

        String url = "" + data.charAt(6) + "" + data.charAt(7) + "" + data.charAt(8) + "" +
                data.charAt(9) + "" + data.charAt(3) + "" + data.charAt(4) + "" + data.charAt(0) + "" +
                data.charAt(1) + "_" + hora.charAt(0) + "" + hora.charAt(1) + "h" + hora.charAt(3) + "" +
                hora.charAt(4) + "_" + categoria + "_frente.pdf";

        String urlBase = "http://www.futeboldospais.com.br/campeonato2017/sumulas/Jogo_" + url;

        assertEquals("http://www.futeboldospais.com.br/campeonato2017/sumulas/Jogo_20170923_08h30_Master_frente.pdf", urlBase);
    }
}
