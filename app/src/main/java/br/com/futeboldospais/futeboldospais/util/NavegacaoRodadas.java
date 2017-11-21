package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadas {

    private Fragment fragmentoSelecionado;
    private String titulo;


    public Fragment getFragmentoSelecionado() {
        return fragmentoSelecionado;
    }

    public void setFragmentoSelecionado(Fragment fragmentoSelecionado) {
        this.fragmentoSelecionado = fragmentoSelecionado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
