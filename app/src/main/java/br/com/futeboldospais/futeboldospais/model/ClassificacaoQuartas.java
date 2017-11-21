package br.com.futeboldospais.futeboldospais.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author Denilson Araujo on 31/10/2017
 */

public class ClassificacaoQuartas implements Serializable{

    private String categoria;
    private String grupo;
    private List<Classificacao> listaClassificacao;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public List<Classificacao> getListaClassificacao() {
        return listaClassificacao;
    }

    public void setListaClassificacao(List<Classificacao> listaClassificacao) {
        this.listaClassificacao = listaClassificacao;
    }

    @Override
    public String toString() {
        return "ClassificacaoQuartas{" +
                "categoria='" + categoria + '\'' +
                ", grupo='" + grupo + '\'' +
                ", listaClassificacao=" + listaClassificacao +
                '}';
    }
}