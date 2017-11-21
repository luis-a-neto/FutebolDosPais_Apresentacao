package br.com.futeboldospais.futeboldospais.util;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Grazielly on 29/10/2017.
 */

public class ViewHolderSuspensao {

    private ImageView escudo;
    private TextView jogador;
    private TextView numero;
    private TextView categoria;
    private TextView criterio;
    private TextView jogos;
    private ImageView motivo;

    public ViewHolderSuspensao(){
        //Construtor padrão
    }

    public ViewHolderSuspensao(ImageView escudo, TextView jogador, TextView numero, TextView categoria, TextView criterio, TextView jogos, ImageView motivo) {
        this.escudo = escudo;
        this.jogador = jogador;
        this.numero = numero;
        this.categoria = categoria;
        this.criterio = criterio;
        this.jogos = jogos;
        this.motivo = motivo;

    }

    public ImageView getEscudo() {
        return escudo;
    }

    public void setEscudo(ImageView escudo) {
        this.escudo = escudo;
    }

    public TextView getJogador() {
        return jogador;
    }

    public void setJogador(TextView jogador) {
        this.jogador = jogador;
    }

    public TextView getNumero() {
        return numero;
    }

    public void setNumero(TextView numero) {
        this.numero = numero;
    }

    public TextView getCategoria() {
        return categoria;
    }

    public void setCategoria(TextView categoria) {
        this.categoria = categoria;
    }

    public TextView getCriterio() {
        return criterio;
    }

    public void setCriterio(TextView criterio) {
        this.criterio = criterio;
    }

    public TextView getJogos() {
        return jogos;
    }

    public void setJogos(TextView jogos) {
        this.jogos = jogos;
    }

    public ImageView getMotivo(){
        return motivo;
    }

    public void setMotivo(ImageView motivo) {
        this.motivo = motivo;
    }
}
