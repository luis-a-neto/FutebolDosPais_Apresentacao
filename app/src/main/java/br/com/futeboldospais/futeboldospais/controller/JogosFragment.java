package br.com.futeboldospais.futeboldospais.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.service.ResultadoService;
import br.com.futeboldospais.futeboldospais.util.ModalJogos;
import br.com.futeboldospais.futeboldospais.util.NavegacaoRodadasHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class JogosFragment extends Fragment {

    private Button btnProximaRodada;
    private Button btnRodadaAnterior;
    private TextView txtRodada;

    private String titulo;
    private Fragment fragmentoSelecionado;
    private ResultadoService resultadoService;

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static JogosFragment fragment = null;

    public static JogosFragment newInstance() {
        if (fragment == null) {
            fragment = new JogosFragment();
        }
        return fragment;
    }

    public JogosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_jogos, container, false);

        //Seleciona e exibe a titulo atual do campeonato
        resultadoService = new ResultadoService();
        fragmentoSelecionado = NavegacaoRodadasHelper.rodadaAtual(resultadoService.listarDadosRodadaAtual(getActivity().getBaseContext())).getFragmentoSelecionado();
        titulo = NavegacaoRodadasHelper.rodadaAtual(resultadoService.listarDadosRodadaAtual(getActivity().getBaseContext())).getTitulo();

        txtRodada = (TextView) view.findViewById(R.id.txt_rodada);
        txtRodada.setText(titulo);
        //Inicia uma transação com o fragmento selecionado ao criar a view
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
        transaction.commit();

        //Botão para voltar uma titulo
        btnRodadaAnterior = (Button) view.findViewById(R.id.btn_anterior);
        btnRodadaAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chama a classe NavegaçãoRodadas para receber um titulo de titulo e uma instancia da titulo anterior
                if (!fragmentoSelecionado.equals(PrimeiraRodadaFragment.getInstance())) {
                    titulo = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.ANTERIOR, fragmentoSelecionado).getTitulo();
                    fragmentoSelecionado = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.ANTERIOR, fragmentoSelecionado).getFragmentoSelecionado();
                    txtRodada.setText(titulo);
                    //Inicia a transação entre fragments
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.entrar_da_esquerda, R.anim.sair_para_direita, R.anim.entrar_da_direita, R.anim.sair_para_esquerda);
                    transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                    transaction.commit();
                }
            }
        });

        //Botão para avançar uma titulo
        btnProximaRodada = (Button) view.findViewById(R.id.btn_proximo);
        btnProximaRodada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chama a classe NavegaçãoRodadas para receber um titulo de titulo e uma instancia da proxima titulo
                if (!fragmentoSelecionado.equals(VigesimaOitavaRodadaFragment.getInstance())) {
                    titulo = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.PROXIMO, fragmentoSelecionado).getTitulo();
                    fragmentoSelecionado = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.PROXIMO, fragmentoSelecionado).getFragmentoSelecionado();
                    txtRodada.setText(titulo);
                    //Inicia a transação entre fragments
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.entrar_da_direita, R.anim.sair_para_esquerda, R.anim.entrar_da_esquerda, R.anim.sair_para_direita);
                    transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                    transaction.commit();
                }
            }
        });

        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {
                        Log.d("teste", "onFling has been called!");
                        final int SWIPE_MIN_DISTANCE = 120;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 200;
                        try {
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                                return false;
                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                if (!fragmentoSelecionado.equals(VigesimaOitavaRodadaFragment.getInstance())) {
                                    titulo = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.PROXIMO, fragmentoSelecionado).getTitulo();
                                    fragmentoSelecionado = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.PROXIMO, fragmentoSelecionado).getFragmentoSelecionado();
                                    txtRodada.setText(titulo);
                                    //Inicia a transação entre fragments
                                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                                    transaction.setCustomAnimations(R.anim.entrar_da_direita, R.anim.sair_para_esquerda, R.anim.entrar_da_esquerda, R.anim.sair_para_direita);
                                    transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                                    transaction.commit();
                                }
                            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                if (!fragmentoSelecionado.equals(PrimeiraRodadaFragment.getInstance())) {
                                    titulo = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.ANTERIOR, fragmentoSelecionado).getTitulo();
                                    fragmentoSelecionado = NavegacaoRodadasHelper.selecionaRodada(NavegacaoRodadasHelper.ANTERIOR, fragmentoSelecionado).getFragmentoSelecionado();
                                    txtRodada.setText(titulo);
                                    //Inicia a transação entre fragments
                                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                                    transaction.setCustomAnimations(R.anim.entrar_da_esquerda, R.anim.sair_para_direita, R.anim.entrar_da_direita, R.anim.sair_para_esquerda);
                                    transaction.replace(R.id.frame_jogos, fragmentoSelecionado);
                                    transaction.commit();
                                }
                            }
                        } catch (Exception e) {
                            // nothing
                        }
                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });

        Button btnTipJogos = (Button) view.findViewById(R.id.btn_tip_jogos);

        btnTipJogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModalJogos.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
