package br.com.futeboldospais.futeboldospais.util;

import android.support.v4.app.Fragment;

import br.com.futeboldospais.futeboldospais.controller.DecimaNonaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaOitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaPrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaQuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaSextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.DecimaTerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.NonaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.OitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.PrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.QuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.SextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.TerceiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaOitavaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaPrimeiraRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaQuartaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaQuintaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSegundaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSetimaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaSextaRodadaFragment;
import br.com.futeboldospais.futeboldospais.controller.VigesimaTerceiraRodadaFragment;

/**
 * Created by Daniel Almeida on 15/09/2017.
 */

public class NavegacaoRodadasHelper {

    public static int PROXIMO = 1;
    public static int ANTERIOR = 0;

    private static NavegacaoRodadas navegacaoRodadas;

    public NavegacaoRodadasHelper() {
        //Construtor padrão
    }

    /**
     * Created by Daniel Almeida on 15/09/2017.
     * Recebe uma direção, verifica qual a rodada atual e instacia a proxima rodada
     * de acordo com a direção recebida
     *
     * @param direcao
     * @param fragment
     * @return uma instancia da classe NavegacaoRodadas
     */
    public static NavegacaoRodadas selecionaRodada(int direcao, Fragment fragment) {

        navegacaoRodadas = new NavegacaoRodadas();

        if (direcao == 1) {
            if (fragment.equals(PrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 2º RODADA");
            } else if (fragment.equals(SegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 3º RODADA");
            } else if (fragment.equals(TerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 4º RODADA");
            } else if (fragment.equals(QuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 5º RODADA");
            } else if (fragment.equals(QuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 6º RODADA");
            } else if (fragment.equals(SextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 7º RODADA");
            } else if (fragment.equals(SetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 8º RODADA");
            } else if (fragment.equals(OitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 9º RODADA");
            } else if (fragment.equals(NonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 10º RODADA");
            } else if (fragment.equals(DecimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 1º RODADA");
            } else if (fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 2º RODADA");
            } else if (fragment.equals(DecimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 3º RODADA");
            } else if (fragment.equals(DecimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 4º RODADA");
            } else if (fragment.equals(DecimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 5º RODADA");
            } else if (fragment.equals(DecimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 6º RODADA");
            } else if (fragment.equals(DecimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 7º RODADA");
            } else if (fragment.equals(DecimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 8º RODADA");
            } else if (fragment.equals(DecimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 9º RODADA");
            } else if (fragment.equals(DecimaNonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 10º RODADA");
            } else if (fragment.equals(VigesimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 1º RODADA");
            } else if (fragment.equals(VigesimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 2º RODADA");
            } else if (fragment.equals(VigesimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 3º RODADA");
            } else if (fragment.equals(VigesimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 4º RODADA");
            } else if (fragment.equals(VigesimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 5º RODADA");
            } else if (fragment.equals(VigesimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 6º RODADA");
            } else if (fragment.equals(VigesimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("SEMIFINAIS");
            } else if (fragment.equals(VigesimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("FINAIS");
            }

        } else if (direcao == 0) {
            if (fragment.equals(VigesimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("SEMIFINAIS");
            } else if (fragment.equals(VigesimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 6º RODADA");
            } else if (fragment.equals(VigesimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 5º RODADA");
            } else if (fragment.equals(VigesimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 4º RODADA");
            } else if (fragment.equals(VigesimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 3º RODADA");
            } else if (fragment.equals(VigesimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 2º RODADA");
            } else if (fragment.equals(VigesimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 1º RODADA");
            } else if (fragment.equals(VigesimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 10º RODADA");
            } else if (fragment.equals(VigesimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 9º RODADA");
            } else if (fragment.equals(DecimaNonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 8º RODADA");
            } else if (fragment.equals(DecimaOitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 7º RODADA");
            } else if (fragment.equals(DecimaSetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 6º RODADA");
            } else if (fragment.equals(DecimaSextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 5º RODADA");
            } else if (fragment.equals(DecimaQuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 4º RODADA");
            } else if (fragment.equals(DecimaQuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 3º RODADA");
            } else if (fragment.equals(DecimaTerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 2º RODADA");
            } else if (fragment.equals(DecimaSegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 1º RODADA");
            } else if (fragment.equals(DecimaPrimeiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 10º RODADA");
            } else if (fragment.equals(DecimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 9º RODADA");
            } else if (fragment.equals(NonaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 8º RODADA");
            } else if (fragment.equals(OitavaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 7º RODADA");
            } else if (fragment.equals(SetimaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 6º RODADA");
            } else if (fragment.equals(SextaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 5º RODADA");
            } else if (fragment.equals(QuintaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 4º RODADA");
            } else if (fragment.equals(QuartaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 3º RODADA");
            } else if (fragment.equals(TerceiraRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 2º RODADA");
            } else if (fragment.equals(SegundaRodadaFragment.getInstance())) {
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 1º RODADA");
            }
        }

        return navegacaoRodadas;
    }

    public static NavegacaoRodadas rodadaAtual(int rodada) {

        navegacaoRodadas = new NavegacaoRodadas();

        switch (rodada) {
            case 1:
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 1º RODADA");
                break;
            case 2:
                navegacaoRodadas.setFragmentoSelecionado(SegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 2º RODADA");
                break;

            case 3:
                navegacaoRodadas.setFragmentoSelecionado(TerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 3º RODADA");
                break;

            case 4:
                navegacaoRodadas.setFragmentoSelecionado(QuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 4º RODADA");
                break;

            case 5:
                navegacaoRodadas.setFragmentoSelecionado(QuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 5º RODADA");
                break;

            case 6:
                navegacaoRodadas.setFragmentoSelecionado(SextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 6º RODADA");
                break;

            case 7:
                navegacaoRodadas.setFragmentoSelecionado(SetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 7º RODADA");
                break;

            case 8:
                navegacaoRodadas.setFragmentoSelecionado(OitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 8º RODADA");
                break;

            case 9:
                navegacaoRodadas.setFragmentoSelecionado(NonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 9º RODADA");
                break;

            case 10:
                navegacaoRodadas.setFragmentoSelecionado(DecimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 10º RODADA");
                break;

            case 11:
                navegacaoRodadas.setFragmentoSelecionado(DecimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 1º RODADA");
                break;

            case 12:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 2º RODADA");
                break;

            case 13:
                navegacaoRodadas.setFragmentoSelecionado(DecimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 3º RODADA");
                break;

            case 14:
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 4º RODADA");
                break;

            case 15:
                navegacaoRodadas.setFragmentoSelecionado(DecimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 5º RODADA");
                break;

            case 16:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 6º RODADA");
                break;

            case 17:
                navegacaoRodadas.setFragmentoSelecionado(DecimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 7º RODADA");
                break;

            case 18:
                navegacaoRodadas.setFragmentoSelecionado(DecimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 8º RODADA");
                break;

            case 19:
                navegacaoRodadas.setFragmentoSelecionado(DecimaNonaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 9º RODADA");
                break;

            case 20:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("2º TURNO - 10º RODADA");
                break;

            case 21:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaPrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 1º RODADA");
                break;

            case 22:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSegundaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 2º RODADA");
                break;

            case 23:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaTerceiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 3º RODADA");
                break;

            case 24:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuartaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 4º RODADA");
                break;

            case 25:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaQuintaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 5º RODADA");
                break;

            case 26:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSextaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("QUARTAS - 6º RODADA");
                break;

            case 27:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaSetimaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("SEMIFINAIS");
                break;

            case 28:
                navegacaoRodadas.setFragmentoSelecionado(VigesimaOitavaRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("FINAIS");
                break;

            default:
                navegacaoRodadas.setFragmentoSelecionado(PrimeiraRodadaFragment.newInstance());
                navegacaoRodadas.setTitulo("1º TURNO - 1º RODADA");
                break;
        }

        return navegacaoRodadas;
    }


}
