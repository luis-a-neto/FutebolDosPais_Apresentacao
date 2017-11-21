package br.com.futeboldospais.futeboldospais.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.futeboldospais.futeboldospais.dao.ResultadoDAO;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.rest.ResultadoRest;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Daniel Almeida on 17/10/2017.
 * Classe service padrão para esconder a lógica de acesso rest e banco de dados
 */

public class ResultadoService {

    private ResultadoDAO dao;
    private ResultadoRest resultadoRest;

    /**
     * Contrutor padrão, instancia um objeto dao e um objeto rest ao ser chamado
     */
    public ResultadoService() {
        dao = new ResultadoDAO();
        resultadoRest = new ResultadoRest();
    }

    /**
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     */
    public List<Resultado> getResultado(int campeonatoAno) throws Exception {

        List<Resultado> lista;

        //String json = resultadoRest.getResultado(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[\n" +
                " {\n" +
                "  \"data\": \"04/03/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente2\": \"Eliton Lopes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"04/03/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Eliton Lopes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"04/03/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Eliton Lopes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"04/03/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/03/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Marco Motta\",\n" +
                "  \"assistente2\": \"Willians Vilela\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/03/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Wagner Rizo\",\n" +
                "  \"assistente2\": \"Willians Vilela\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"1\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/03/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"5\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/03/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Alexandre Augusto\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/03/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"5\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/03/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/03/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"6\",\n" +
                "  \"cartoesVermelhos\": \"4\",\n" +
                "  \"totalCartoes\": \"10\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marco Antonio Pereira Camargo\",\n" +
                "  \"assistente1\": \"Antonio Carlos L. Mendes\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"3\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/03/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"6\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Adriana de Almeida\",\n" +
                "  \"assistente1\": \"Antonio Carlos L. Mendes\",\n" +
                "  \"assistente2\": \"Marco Antonio Pereira Camargo\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"2\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"18/03/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Márcio Bastos\",\n" +
                "  \"assistente1\": \"Marcos Silva Santos Goncalves\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"18/03/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marcos Silva Santos Goncalves\",\n" +
                "  \"assistente1\": \"Robson Ferreira\",\n" +
                "  \"assistente2\": \"Márcio Bastos\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"18/03/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Guilherme Nunes\",\n" +
                "  \"assistente1\": \"Robson Ferreira\",\n" +
                "  \"assistente2\": \"Márcio Bastos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"18/03/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marcos Silva Santos Goncalves\",\n" +
                "  \"assistente1\": \"Robson Ferreira\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"4\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/03/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Celso Batistini\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/03/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"5\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"Marco Motta\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"3\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/03/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Joilson Lino\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"3\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/03/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Bruno Rizo\",\n" +
                "  \"assistente1\": \"Joilson Lino\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/03/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Bruno Rizo\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/03/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Bruno Rizo\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/03/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Aristides Marcondes\",\n" +
                "  \"assistente1\": \"Mauro Lopes\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/03/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Mauro Lopes\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Aristides Marcondes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"4\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/04/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Daniel Sotile\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Jacildo Antonio de Paula\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"5\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/04/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"5\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Daniel Sotile\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/04/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Daniel Sotile\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/04/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/04/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"9\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"9\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Marco Motta\",\n" +
                "  \"assistente2\": \"Norberto Evangelista\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/04/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Norberto Evangelista\",\n" +
                "  \"assistente2\": \"Celso Batistini\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"5\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"08/04/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Leandro Leao\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"08/04/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Leandro Leao\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"08/04/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"5\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Joilson Lino\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"08/04/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"5\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Leandro Leao\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Joilson Lino\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"09/04/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"Mauro Lopes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"09/04/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Mauro Lopes\",\n" +
                "  \"assistente1\": \"Wagner Rizo\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"6\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/05/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Aristides Marcondes\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"7\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/05/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Wagner Rizo\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"7\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/05/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Aristides Marcondes\",\n" +
                "  \"assistente1\": \"Wagner Rizo\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"7\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/05/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Aristides Marcondes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"7\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"13/05/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"6\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"7\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Bruno Rizo\",\n" +
                "  \"assistente1\": \"Vitor Salzani\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"4\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"13/05/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Vitor Salzani\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"13/05/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Bruno Rizo\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Delfino Guimaraes\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"13/05/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vitor Salzani\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Delfino Guimaraes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/05/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"2\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Marco Motta\",\n" +
                "  \"assistente2\": \"Mauro Lopes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/05/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Mauro Lopes\",\n" +
                "  \"assistente2\": \"Vladimir Vassoler\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"8\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/05/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"6\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"6\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vitor Salzani\",\n" +
                "  \"assistente1\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/05/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"&nbsp\",\n" +
                "  \"assistente2\": \"&nbsp\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/05/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Vitor Salzani\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"5\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/05/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"28/05/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Delfino Guimaraes\",\n" +
                "  \"assistente2\": \"Antonio Carlos L. Mendes\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"28/05/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Sao-Bento\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Wagner Rizo\",\n" +
                "  \"assistente2\": \"Antonio Carlos L. Mendes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"9\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/06/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Adenes Barros\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"10\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/06/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Alexandre Augusto\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"10\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/06/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Adenes Barros\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Alexandre Augusto\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"5\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"10\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/06/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Adenes Barros\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"5\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"1\",\n" +
                "  \"rodada\": \"10\",\n" +
                "  \"turno\": \"1\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"04/06/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Mauro Lopes\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"6\",\n" +
                "  \"rodada\": \"11\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"04/06/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Mauro Lopes\",\n" +
                "  \"assistente1\": \"Delfino Guimaraes\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"11\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/06/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Leandro Leao\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Jacildo Antonio de Paula\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"11\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"11/06/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"7\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"7\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Leandro Leao\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"11\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"24/06/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"24/06/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"24/06/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"24/06/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/06/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Daniel Sotile\",\n" +
                "  \"assistente2\": \"Celso Batistini\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"5\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"25/06/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Daniel Sotile\",\n" +
                "  \"assistente2\": \"Delfino Guimaraes\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"4\",\n" +
                "  \"rodada\": \"12\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/07/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jose Rubens Feitosa\",\n" +
                "  \"assistente1\": \"Willians Vilela\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"3\",\n" +
                "  \"notaArbitroEquipe1\": \"2\",\n" +
                "  \"notaArbitroEquipe2\": \"3\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/07/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Jose Rubens Feitosa\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"6\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/07/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Willians Vilela\",\n" +
                "  \"assistente1\": \"Joilson Lino\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"01/07/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Willians Vilela\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/07/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Willians Vilela\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/07/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Willians Vilela\",\n" +
                "  \"assistente1\": \"Alexandre Augusto\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"13\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"29/07/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marcos Silva Santos Goncalves\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"29/07/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Novorizontino\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"29/07/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marcos Silva Santos Goncalves\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"29/07/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jaime Luiz Fundao\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/07/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"5\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Marco Motta\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/07/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"6\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Vladimir Vassoler\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"14\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/08/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Adenes Barros\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/08/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Adenes Barros\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/08/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Celso Batistini\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"05/08/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Adenes Barros\",\n" +
                "  \"assistente1\": \"Celso Batistini\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"5\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/08/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"4\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Edivanio Ferreira Duarte\",\n" +
                "  \"assistente1\": \"Mauro Lopes\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"4\",\n" +
                "  \"notaArbitroEquipe1\": \"5\",\n" +
                "  \"notaArbitroEquipe2\": \"2\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"06/08/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Mauro Lopes\",\n" +
                "  \"assistente1\": \"Edivanio Ferreira Duarte\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"15\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/08/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"5\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"16\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/08/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"5\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"16\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/08/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"6\",\n" +
                "  \"rodada\": \"16\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"12/08/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"16\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/08/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/08/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/08/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Alexandre Augusto\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"19/08/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"20/08/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Leandro Leao\",\n" +
                "  \"assistente1\": \"Eliton Lopes\",\n" +
                "  \"assistente2\": \"Jacildo Antonio de Paula\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"6\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"20/08/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Leandro Leao\",\n" +
                "  \"assistente2\": \"Eliton Lopes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"17\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/08/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"2\",\n" +
                "  \"totalCartoes\": \"6\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"James da Silva Costa\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"6\",\n" +
                "  \"notaArbitroEquipe1\": \"3\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/08/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Leandro Almeida\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"James da Silva Costa\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/08/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"James da Silva Costa\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"26/08/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Leandro Almeida\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"James da Silva Costa\",\n" +
                "  \"notaArbitroMedia\": \"5\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"2\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/08/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Guilherme Nunes\",\n" +
                "  \"assistente2\": \"Delfino Guimaraes\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"27/08/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Vladimir Vassoler\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"7\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"18\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/09/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/09/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Fernando Anunciação\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"5\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/09/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Jeferson Godoi\",\n" +
                "  \"assistente1\": \"Lohan Alves dos Santos\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"02/09/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Ferroviaria\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Fernando Anunciação\",\n" +
                "  \"assistente2\": \"Lohan Alves dos Santos\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/09/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"7\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Edivanio Ferreira Duarte\",\n" +
                "  \"assistente1\": \"Mauro Lopes\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"03/09/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Mauro Lopes\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Edivanio Ferreira Duarte\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"19\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"16/09/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Fernando Anunciação\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"16/09/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Robson Ferreira\",\n" +
                "  \"assistente2\": \"Fernando Anunciação\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"16/09/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Fernando Anunciação\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"16/09/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Robson Ferreira\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"17/09/2017\",\n" +
                "  \"horario\": \"09:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Wagner Rizo\",\n" +
                "  \"assistente1\": \"Guilherme Nunes\",\n" +
                "  \"assistente2\": \"Delfino Guimaraes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"17/09/2017\",\n" +
                "  \"horario\": \"11:00\",\n" +
                "  \"equipe1\": \"Mirassol\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Delfino Guimaraes\",\n" +
                "  \"assistente1\": \"Guilherme Nunes\",\n" +
                "  \"assistente2\": \"Wagner Rizo\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"20\",\n" +
                "  \"turno\": \"2\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"23/09/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"21\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"23/09/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"21\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"23/09/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"6\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"6\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Carlos Alberto Farias\",\n" +
                "  \"assistente1\": \"Jose Jenilton Santos\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"5\",\n" +
                "  \"notaArbitroEquipe1\": \"0\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"21\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"23/09/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"Jose Jenilton Santos\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"21\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/09/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"James da Silva Costa\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"22\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/09/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"1\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Valmir Batista\",\n" +
                "  \"assistente1\": \"Celso Batistini\",\n" +
                "  \"assistente2\": \"Adriana de Almeida\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"5\",\n" +
                "  \"rodada\": \"22\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/09/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Celso Batistini\",\n" +
                "  \"assistente1\": \"Valmir Batista\",\n" +
                "  \"assistente2\": \"James da Silva Costa\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"22\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"30/09/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"2\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Valmir Batista\",\n" +
                "  \"assistente1\": \"Adriana de Almeida\",\n" +
                "  \"assistente2\": \"James da Silva Costa\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"6\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"22\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"07/10/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Willian Rodrigues\",\n" +
                "  \"assistente1\": \"Guilherme Nunes\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"7\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"4\",\n" +
                "  \"rodada\": \"23\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"07/10/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"5\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marcos Tadeu\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"23\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"07/10/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"6\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Willian Rodrigues\",\n" +
                "  \"assistente1\": \"Guilherme Nunes\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"23\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"07/10/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"2\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marcos Tadeu\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Guilherme Nunes\",\n" +
                "  \"notaArbitroMedia\": \"8\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"7\",\n" +
                "  \"rodada\": \"23\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/10/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe2\": \"6\",\n" +
                "  \"cartoesAmarelos\": \"4\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"5\",\n" +
                "  \"categoria\": \"&nbsp\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"5\",\n" +
                "  \"notaArbitroEquipe1\": \"0\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"24\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/10/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Botafogo\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"3\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"24\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/10/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"golsEquipe1\": \"3\",\n" +
                "  \"equipe2\": \"Red-Bull\",\n" +
                "  \"golsEquipe2\": \"4\",\n" +
                "  \"cartoesAmarelos\": \"1\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"1\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Joilson Lino\",\n" +
                "  \"assistente1\": \"Giovanni Crescencio\",\n" +
                "  \"assistente2\": \"Julio Cesar Goncalves\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"24\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"21/10/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Linense\",\n" +
                "  \"golsEquipe1\": \"1\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"3\",\n" +
                "  \"cartoesVermelhos\": \"1\",\n" +
                "  \"totalCartoes\": \"4\",\n" +
                "  \"categoria\": \"Senior\",\n" +
                "  \"arbitro\": \"Jacildo Antonio de Paula\",\n" +
                "  \"assistente1\": \"Julio Cesar Goncalves\",\n" +
                "  \"assistente2\": \"Giovanni Crescencio\",\n" +
                "  \"notaArbitroMedia\": \"10\",\n" +
                "  \"notaArbitroEquipe1\": \"10\",\n" +
                "  \"notaArbitroEquipe2\": \"9\",\n" +
                "  \"rodada\": \"24\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"28/10/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"golsEquipe1\": \"0\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"golsEquipe2\": \"3\",\n" +
                "  \"cartoesAmarelos\": \"2\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"2\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Vladimir Vassoler\",\n" +
                "  \"assistente1\": \"Nelson Izidoro\",\n" +
                "  \"assistente2\": \"Luiz Henrique Pimentel\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"8\",\n" +
                "  \"notaArbitroEquipe2\": \"10\",\n" +
                "  \"rodada\": \"25\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " },\n" +
                " {\n" +
                "  \"data\": \"28/10/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"golsEquipe1\": \"7\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"golsEquipe2\": \"0\",\n" +
                "  \"cartoesAmarelos\": \"0\",\n" +
                "  \"cartoesVermelhos\": \"0\",\n" +
                "  \"totalCartoes\": \"0\",\n" +
                "  \"categoria\": \"Master\",\n" +
                "  \"arbitro\": \"Marco Motta\",\n" +
                "  \"assistente1\": \"Luiz Henrique Pimentel\",\n" +
                "  \"assistente2\": \"Nelson Izidoro\",\n" +
                "  \"notaArbitroMedia\": \"9\",\n" +
                "  \"notaArbitroEquipe1\": \"9\",\n" +
                "  \"notaArbitroEquipe2\": \"8\",\n" +
                "  \"rodada\": \"25\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"vencedor\": \"0\"\n" +
                " }\n" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Resultado>>() {
        }.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        return lista;
    }

    /**
     * @param campeonatoAno Ano atual do campeonato no servidor
     * @return ArrayList de objetos parseados de um JSONArray
     * @throws Exception JSONException
     * @author Daniel Almeida
     * Este método acessa a camada rest para buscar um array de json no formato String e
     * faz a sua conversão para array de objetos utilizando reflexão
     */
    public List<Resultado> getJogo(int campeonatoAno) throws Exception {

        List<Resultado> lista;

        //String json = resultadoRest.getJogo(ConfiguracaoService.urlBase(campeonatoAno));

        String json = "[\n" +
                " {\n" +
                "  \"rodada\": \"25\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"28/10/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"categoria\": \"Master\"\n" +
                " },\n" +
                " {\n" +
                "  \"rodada\": \"25\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"28/10/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"categoria\": \"Master\"\n" +
                " },\n" +
                " {\n" +
                "  \"rodada\": \"26\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"11/11/2017\",\n" +
                "  \"horario\": \"08:30\",\n" +
                "  \"equipe1\": \"Ponte-Preta\",\n" +
                "  \"equipe2\": \"Botafogo\",\n" +
                "  \"categoria\": \"Senior\"\n" +
                " },\n" +
                " {\n" +
                "  \"rodada\": \"26\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"11/11/2017\",\n" +
                "  \"horario\": \"10:30\",\n" +
                "  \"equipe1\": \"Sao-Bento\",\n" +
                "  \"equipe2\": \"Novorizontino\",\n" +
                "  \"categoria\": \"Senior\"\n" +
                " },\n" +
                " {\n" +
                "  \"rodada\": \"26\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"11/11/2017\",\n" +
                "  \"horario\": \"12:30\",\n" +
                "  \"equipe1\": \"Red-Bull\",\n" +
                "  \"equipe2\": \"Mirassol\",\n" +
                "  \"categoria\": \"Senior\"\n" +
                " },\n" +
                " {\n" +
                "  \"rodada\": \"26\",\n" +
                "  \"turno\": \"3\",\n" +
                "  \"data\": \"11/11/2017\",\n" +
                "  \"horario\": \"14:30\",\n" +
                "  \"equipe1\": \"Ferroviaria\",\n" +
                "  \"equipe2\": \"Linense\",\n" +
                "  \"categoria\": \"Senior\"\n" +
                " }\n" +
                "]";

        Gson gson = new Gson();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Type listType = new TypeToken<List<Resultado>>() {
        }.getType();
        lista = gson.fromJson(jsonArray.toString(), listType);

        for (Resultado resultado : lista) {
            Log.d("teste", "" + resultado.getRodada() + " - " + resultado.getTurno() + " - " + resultado.getData() + " - " +
                    resultado.getHorario() + " - " + resultado.getEquipe1() + " - " + resultado.getEquipe2() + " - " +
                    resultado.getCategoria());
        }

        return lista;
    }

    /**
     * @param bd             Conexão de gravação passada para a camada dao
     * @param listaResultado ArrayList de Resultado passado para a camada dao
     * @param listaJogo      ArrayList de Jogo passado para a camada dao
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     */
    public void inserirDados(SQLiteDatabase bd, List<Resultado> listaResultado, List<Resultado> listaJogo) {
        dao.inserirDadosResultado(bd, listaResultado);
        dao.inserirDadosJogo(bd, listaJogo);
    }

    /**
     * @param bd Conexão de gravação passada para a camada dao
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e esconder a complexidade das operações
     */
    public void deletarDados(SQLiteDatabase bd) {
        dao.deletarDados(bd);
    }

    public int listarDadosRodadaAtual(Context context) {
        return dao.listarDadosRodadaAtual(context);
    }

    /**
     * @param context Contexto da aplicação passado para a camada dao
     * @return Vetor de objeto do tipo Resultado
     * @author Daniel Almeida
     * Este método serve para acessar a camada dao e retornar um vetor de objetos
     */
    public Resultado[] listarDadosPorRodadaETurno(Context context, int rodada, int turno) {
        return dao.listarDadosPorRodadaETurno(context, rodada, turno);
    }


}
