package br.com.futeboldospais.futeboldospais.controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.AdapterPadrao;
import br.com.futeboldospais.futeboldospais.util.ArtilhariaAdapter;
import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.service.ArtilhariaService;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtilhariaFragment extends Fragment {

    private EditText valorBusca;
    private Button buscar;
    private Button encerrar;
    private LinearLayout div_busca;
    private RadioGroup toggle;
    private RadioButton rbtMaster;
    private RadioButton rbtSenior;
    private ListView tabelaArtilharia;
    private Artilharia[] listaArtilharia;
    private ArtilhariaAdapter adapter;
    private ArtilhariaService artilhariaService;
    private int tipoBusca;

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ArtilhariaFragment fragment = null;

    public static ArtilhariaFragment newInstance() {
        if (fragment == null) {
            fragment = new ArtilhariaFragment();
        }
        return fragment;
    }


    public ArtilhariaFragment() {
        // Required empty public constructor
    }

    /**
     * Criado por: Pâmela e Vinicius em 13/09/2017
     * <p>
     * Alterado por: Daniel Almeida
     * Objetivo: Otimizar a mecanica de navegação
     * Data alteração: 14/09/2017
     * <p>
     * Alterado por: Pâmela e Vinicius
     * Objetivo: inclusão da lista de artilharias
     * Dt. alteração: 18.10.2017
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_artilharia, container, false);

        valorBusca = (EditText) view.findViewById(R.id.valor_busca);
        buscar = (Button) view.findViewById(R.id.btn_buscar_artilheiro);
        encerrar = (Button) view.findViewById(R.id.btn_encerrar_busca_artilheiro);
        div_busca = (LinearLayout) view.findViewById(R.id.div_busca);
        toggle = (RadioGroup) view.findViewById(R.id.toggle);

        div_busca.setVisibility(View.INVISIBLE);


        rbtSenior = (RadioButton) view.findViewById(R.id.rbt_senior);

        rbtMaster = (RadioButton) view.findViewById(R.id.rbt_master);

        rbtMaster.setTextColor(ContextCompat
                .getColor(getContext(),
                        R.color.white));
        rbtMaster.setBackground(ContextCompat
                .getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_cinza));

        tabelaArtilharia = (ListView) view.findViewById(R.id.lista_melhores_jogadores);

        artilhariaService = new ArtilhariaService();
        listaArtilharia = artilhariaService
                .listarDadosPorCategoria(getActivity()
                        .getBaseContext(),
                        getString(R.string.string_master));
        tipoBusca = 0;

        if (listaArtilharia.length > 0) {
            adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
            tabelaArtilharia.setAdapter(adapter);
        } else {
            AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                    getString(R.string.insucesso_pesquisa));

            tabelaArtilharia.setAdapter(adapterPadrao);
        }

        rbtMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaArtilharia = artilhariaService
                        .listarDadosPorCategoria(getActivity()
                                .getBaseContext(),
                                getString(R.string.string_master));

                if (listaArtilharia.length > 0) {
                    adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
                    tabelaArtilharia.setAdapter(adapter);
                } else {
                    AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                            getString(R.string.insucesso_pesquisa));
                    tabelaArtilharia.setAdapter(adapterPadrao);
                }

                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_cinza));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(),
                        R.color.black));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_branco));

                tipoBusca = 0;
            }
        });

        rbtSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity()
                        .getBaseContext(),
                        getString(R.string.string_master));

                if (listaArtilharia.length > 0) {
                    adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
                    tabelaArtilharia.setAdapter(adapter);
                } else {
                    AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                            getString(R.string.insucesso_pesquisa));
                    tabelaArtilharia.setAdapter(adapterPadrao);
                }

                rbtMaster.setTextColor(ContextCompat.getColor(getContext(), R.color.black));
                rbtMaster.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_esq_branco));

                rbtSenior.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                rbtSenior.setBackground(ContextCompat.getDrawable(getContext(),
                        R.drawable.arredondar_borda_dir_cinza));

                tipoBusca = 1;
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
                    if (tipoBusca == 0) {
                        listaArtilharia = artilhariaService
                                .listarDadosPorCategoriaENome(getActivity()
                                                .getBaseContext(),
                                        getString(R.string.string_master),
                                        valorBusca.getText()
                                                .toString());
                    } else {
                        listaArtilharia = artilhariaService
                                .listarDadosPorCategoriaENome(getActivity()
                                                .getBaseContext(),
                                        getString(R.string.string_senior),
                                        valorBusca.getText().toString());
                    }

                    if (listaArtilharia.length > 0) {
                        adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
                        tabelaArtilharia.setAdapter(adapter);
                    } else {
                        AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                                getString(R.string.insucesso_pesquisa));
                        tabelaArtilharia.setAdapter(adapterPadrao);
                    }
                } else {
                    if (tipoBusca == 0) {
                        listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity()
                                .getBaseContext(), getString(R.string.string_master));
                    } else {
                        listaArtilharia = artilhariaService.listarDadosPorCategoria(getActivity()
                                .getBaseContext(), getString(R.string.string_senior));
                    }

                    if (listaArtilharia.length > 0) {
                        adapter = new ArtilhariaAdapter(listaArtilharia, getActivity());
                        tabelaArtilharia.setAdapter(adapter);
                    } else {
                        AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(),
                                getString(R.string.insucesso_pesquisa));
                        tabelaArtilharia.setAdapter(adapterPadrao);
                    }
                }
            }
        });

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