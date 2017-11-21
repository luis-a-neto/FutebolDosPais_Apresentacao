package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisMasterAdapter;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisSeniorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificacaoQuartasFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ClassificacaoQuartasFragment fragment = null;

    private RadioButton master;
    private RadioButton senior;
    private ViewPager pager;

    private QuartasFinaisSeniorAdapter adapterSenior;
    private QuartasFinaisMasterAdapter adapterMaster;

    public static ClassificacaoQuartasFragment newInstance() {
        if (fragment == null) {
            fragment = new ClassificacaoQuartasFragment();
        }
        return fragment;
    }

    public ClassificacaoQuartasFragment() {
        // Required empty public constructor
    }


    /**
     *
     * Created by Pamela Fidelis on 11.11.2017
     * Objetivo: troca de tela
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classificacao_quartas, container, false);

        pager = (ViewPager) view.findViewById(R.id.pager);


        master = (RadioButton) view.findViewById(R.id.master);
        senior = (RadioButton) view.findViewById(R.id.senior);

        master.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.efeito_filter));
        master.setChecked(true);
        senior.setBackground(null);

        if(master.isChecked()){
            Log.i("quartas","master selecionado");
            adapterMaster = new QuartasFinaisMasterAdapter(getFragmentManager());
            pager.setAdapter(adapterMaster);
        }else if(senior.isChecked()){
            Log.i("quartas","senior selecionado");
            adapterSenior = new QuartasFinaisSeniorAdapter(getFragmentManager());
            pager.setAdapter(adapterSenior);
        }


        /**
         * Created by Denilson Araújo on 24.11.2017
         * Objetivo: Customização dos botões
         */
        // acao de mudar a tabela
        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("quarta", "master clicado");
                master.setChecked(true);
                senior.setChecked(false);
                master.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.efeito_filter));
                senior.setBackground(null);

                adapterMaster = new QuartasFinaisMasterAdapter(getFragmentManager());
                pager.setAdapter(adapterMaster);
            }
        });

        //acao de mudar a tabela
        senior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("quarta", "clicouSenior");
                master.setChecked(false);
                senior.setChecked(true);

                senior.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.efeito_filter));
                master.setBackground(null);

                adapterSenior = new QuartasFinaisSeniorAdapter(getFragmentManager());
                pager.setAdapter(adapterSenior);
            }
        });
        return view;
    }

}
