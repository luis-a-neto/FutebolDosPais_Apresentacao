package br.com.futeboldospais.futeboldospais.util;

import android.widget.TextView;

/**
 * Created by Pamela Fidelis on 12/11/2017.
 */

public class ViewHolderQuartasFinaisDireita {

    private TextView pontosGanhos;
    private TextView jogos;
    private TextView vitorias;
    private TextView saldoGols;


    public ViewHolderQuartasFinaisDireita(TextView pontosGanhos, TextView jogos, TextView vitorias, TextView saldoGols) {
        this.pontosGanhos = pontosGanhos;
        this.jogos = jogos;
        this.vitorias = vitorias;
        this.saldoGols = saldoGols;

    }

    public TextView getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(TextView pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public TextView getJogos() {
        return jogos;
    }

    public void setJogos(TextView jogos) {
        this.jogos = jogos;
    }

    public TextView getVitorias() {
        return vitorias;
    }

    public void setVitorias(TextView vitorias) {
        this.vitorias = vitorias;
    }

    public TextView getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(TextView saldoGols) {
        this.saldoGols = saldoGols;
    }
}
