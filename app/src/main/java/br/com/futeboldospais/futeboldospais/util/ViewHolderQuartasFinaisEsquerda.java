package br.com.futeboldospais.futeboldospais.util;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pamela Fidelis on 15/11/17.
 */

public class ViewHolderQuartasFinaisEsquerda {

    private TextView posicao;
    private ImageView escudo;
    private TextView equipe;

    public ViewHolderQuartasFinaisEsquerda(TextView posicao, ImageView escudo, TextView equipe) {
        this.posicao = posicao;
        this.escudo = escudo;
        this.equipe = equipe;

        Log.d("quarta", "Entrou no ViewHolderQuartasFinaisEsq");
    }

    public TextView getPosicao() {
        return posicao;
    }

    public void setPosicao(TextView posicao) {
        this.posicao = posicao;
    }

    public ImageView getEscudo() {
        return escudo;
    }

    public void setEscudo(ImageView escudo) {
        this.escudo = escudo;
    }

    public TextView getEquipe() {
        return equipe;
    }

    public void setEquipe(TextView equipe) {
        this.equipe = equipe;
    }
}
