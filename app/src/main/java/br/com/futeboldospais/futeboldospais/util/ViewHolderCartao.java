package br.com.futeboldospais.futeboldospais.util;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bruno e Solange on 18/10/2017.
 */

public class ViewHolderCartao {

    private TextView jogador;
    private ImageView equipe;
    private TextView data;
    /*private TextView juiz;*/
    private ImageView adversario;
    private TextView tempo;
    private TextView numero;

    public ViewHolderCartao(TextView jogador, ImageView equipe, TextView data,/* TextView juiz,*/ ImageView adversario, TextView tempo, TextView numero) {
        this.jogador = jogador;
        this.equipe = equipe;
        this.data = data;
        /*this.juiz = juiz;*/
        this.adversario = adversario;
        this.tempo = tempo;
        this.numero = numero;
    }

    public TextView getJogador() {
        return jogador;
    }

    public void setJogador(TextView jogador) {
        this.jogador = jogador;
    }

    public ImageView getEquipe() {
        return equipe;
    }

    public void setEquipe(ImageView equipe) {
        this.equipe = equipe;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    /*public TextView getJuiz() {
        return juiz;
    }

    public void setJuiz(TextView juiz) {
        this.juiz = juiz;
    }*/

    public ImageView getAdversario() {
        return adversario;
    }

    public void setAdversario(ImageView adversario) {
        this.adversario = adversario;
    }

    public TextView getTempo() {
        return tempo;
    }

    public void setTempo(TextView tempo) {
        this.tempo = tempo;
    }

    public TextView getNumero() {
        return numero;
    }

    public void setNumero(TextView numero) {
        this.numero = numero;
    }
}
