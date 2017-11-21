package br.com.futeboldospais.futeboldospais.util;

/**
 * Created by ThirdSystem on 05/11/2017.
 */

public class ObtemJsonDeConfiguracao {

    public static String comParametrosASeremAlterados(int versaoAtualizacao){

        String json = "{" +
                "\"campeonatoAno\":\"2017\"," +
                "\"homenageado\":\"Torneio Luigi Cremasco\"," +
                "\"tema\":\"Campeonato Paulista\"," +
                "\"versaoAtualizacao\":\"" + versaoAtualizacao + "\"" +
                "}";

        return json;
    }

    public static String comValorDeAtributoIncorreto(){

        String json = "{" +
                "\"campeonatoAno\":\"Goiaba\"," +
                "\"homenageado\":\"Torneio Luigi Cremasco\"," +
                "\"tema\":\"Campeonato Paulista\"," +
                "\"versaoAtualizacao\":\"Maça\"" +
                "}";

        return json;
    }
}
