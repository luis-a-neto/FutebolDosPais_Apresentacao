package br.com.futeboldospais.futeboldospais.controller;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Cartao;
import br.com.futeboldospais.futeboldospais.service.CartaoService;
import br.com.futeboldospais.futeboldospais.util.AdapterPadrao;
import br.com.futeboldospais.futeboldospais.util.CartaoAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartoesFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static CartoesFragment fragment = null;

    public static CartoesFragment newInstance() {
        if (fragment == null) {
            fragment = new CartoesFragment();
        }
        return fragment;
    }

    private EditText valorBusca;
    private Button buscar;
    private Button encerrar;
    private LinearLayout div_busca;
    private RadioGroup toggle;
    private RadioButton rbtAmarelo;
    private RadioButton rbtVermelho;
    private ListView tabelaCartao;
    private Cartao[] listaCartao;
    private CartaoAdapter adapter;
    private CartaoService cartaoService;
    private int tipoBusca;

    public CartoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_cartoes, container, false);

        valorBusca = (EditText) view.findViewById(R.id.valor_busca_cartoes);
        buscar = (Button) view.findViewById(R.id.btn_buscar_cartoes);
        encerrar = (Button) view.findViewById(R.id.btn_encerrar_busca_cartoes);
        div_busca = (LinearLayout) view.findViewById(R.id.div_busca_cartoes);
        toggle = (RadioGroup) view.findViewById(R.id.toggle);

        div_busca.setVisibility(View.INVISIBLE);

        rbtVermelho = (RadioButton) view.findViewById(R.id.rbt_vermelho);

        rbtAmarelo = (RadioButton) view.findViewById(R.id.rbt_amarelo);
        rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(),
                R.drawable.arredondar_borda_esq_cinza));

        tabelaCartao = (ListView) view.findViewById(R.id.cartoes_tabela);

        cartaoService = new CartaoService();
        listaCartao = cartaoService.listarDadosCartaoaAmarelo(getActivity()
                .getBaseContext());
        tipoBusca = 0;

        if (listaCartao.length > 0) {
            adapter = new CartaoAdapter(listaCartao, getActivity());
            tabelaCartao.setAdapter(adapter);
        } else {
            AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(), getString(R.string.string_master));
            tabelaCartao.setAdapter(adapterPadrao);
        }

        rbtAmarelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_cinza));

                rbtVermelho.setTextColor(ContextCompat.getColor(getContext(),
                        R.color.black));
                rbtVermelho.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_branco));

                listaCartao = cartaoService.listarDadosCartaoaAmarelo(getActivity().getBaseContext());
                tipoBusca = 0;

                if (listaCartao.length > 0) {
                    adapter = new CartaoAdapter(listaCartao, getActivity());
                    tabelaCartao.setAdapter(adapter);
                } else {
                    AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                            getString(R.string.insucesso_pesquisa));
                    tabelaCartao.setAdapter(adapterPadrao);
                }
            }
        });

        rbtVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rbtAmarelo.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtAmarelo.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_branco));

                rbtVermelho.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtVermelho.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_cinza));

                listaCartao = cartaoService.listarDadosCartaoVermelho(
                        getActivity()
                                .getBaseContext());
                tipoBusca = 1;

                if (listaCartao.length > 0) {
                    adapter = new CartaoAdapter(listaCartao, getActivity());
                    tabelaCartao.setAdapter(adapter);
                } else {
                    AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                            getString(R.string.insucesso_pesquisa));
                    tabelaCartao.setAdapter(adapterPadrao);
                }
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                div_busca.setVisibility(View.VISIBLE);
                buscar.setVisibility(View.INVISIBLE);
                toggle.setVisibility(View.INVISIBLE);
                mostrarTecladoComFocus(valorBusca, getActivity());
            }
        });

        encerrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view1) {
                div_busca.setVisibility(View.INVISIBLE);
                buscar.setVisibility(View.VISIBLE);
                toggle.setVisibility(View.VISIBLE);
                valorBusca.setText(null);
                fecharTeclado(getView(), getActivity());
            }
        });

        valorBusca.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (s.length() != 0) {
                    boolean teste = rbtAmarelo.isChecked();
                    if (tipoBusca == 0) {
                        listaCartao = cartaoService.listarDadosCartaoaAmareloPorJogadorEEquipe(getActivity().getBaseContext(), valorBusca.getText().toString());
                    } else {
                        listaCartao = cartaoService.listarDadosCartaoVermelhoPorJogadorEEquipe(getActivity().getBaseContext(), valorBusca.getText().toString());
                    }


                    if (listaCartao.length > 0) {
                        adapter = new CartaoAdapter(listaCartao, getActivity());
                        tabelaCartao.setAdapter(adapter);
                    } else {
                        AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(), getString(R.string.insucesso_pesquisa));
                        tabelaCartao.setAdapter(adapterPadrao);
                    }
                } else {
                    if (tipoBusca == 0) {
                        listaCartao = cartaoService.listarDadosCartaoaAmarelo(getActivity().getBaseContext());
                    } else {
                        listaCartao = cartaoService.listarDadosCartaoVermelho(getActivity().getBaseContext());
                    }

                    if (listaCartao.length > 0) {
                        adapter = new CartaoAdapter(listaCartao, getActivity());
                        tabelaCartao.setAdapter(adapter);
                    } else {
                        AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                                getString(R.string.insucesso_pesquisa));
                        tabelaCartao.setAdapter(adapterPadrao);
                    }
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public static void mostrarTecladoComFocus(View view, Activity activity) {
        try {
            view.requestFocus();
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fecharTeclado(View view, Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }
}
