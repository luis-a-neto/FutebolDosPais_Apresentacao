package br.com.futeboldospais.futeboldospais;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Type;
import java.util.List;

import br.com.futeboldospais.futeboldospais.dao.BancoDadosHelper;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;

import static org.junit.Assert.assertEquals;

/**
 * Created by ThirdSystem on 20/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class QuartasInstrumentedTest {

    private Context appContext;
    private ClassificacaoQuartasService classificacaoQuartasService;
    private List<ClassificacaoQuartas> lista;
    private SQLiteDatabase db;

    @Before
    public void setContext() {
        appContext = InstrumentationRegistry.getTargetContext();
        classificacaoQuartasService = new ClassificacaoQuartasService();

        db = BancoDadosHelper.FabricaDeConexao.getConexaoServico(appContext);

        try {
            lista = classificacaoQuartasService.getClassificacaoQuartas(2017);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Ignore
    public void testaCadastroDeQuartas() {
        assertEquals(16, classificacaoQuartasService.inserirDados(db, lista));
    }

    @Test
    public void testaBuscaDeEquipePorGrupoCategoriaEPosicao() {
        assertEquals("Ponte-Preta", classificacaoQuartasService.buscarEquipeNaPosicao(appContext, "Senior", "Repescagem", 1));
    }
}
