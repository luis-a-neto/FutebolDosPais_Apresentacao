package br.com.futeboldospais.futeboldospais;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.service.ArtilhariaService;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    ArtilhariaService artilhariaService;

    @Before
    public void before(){
        artilhariaService = new ArtilhariaService();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        artilhariaService = new ArtilhariaService();

        Artilharia[] listaArtilharia = artilhariaService.listarDadosPorCategoria(appContext, "Master");

        for(Artilharia artilharia : listaArtilharia) {
            //System.out.println("categoria: " + artilharia.getCategoria());
            assertEquals("Master", artilharia.getCategoria());
        }
        //assertEquals("br.com.futeboldospais.futeboldospais", appContext.getPackageName());
    }
}
