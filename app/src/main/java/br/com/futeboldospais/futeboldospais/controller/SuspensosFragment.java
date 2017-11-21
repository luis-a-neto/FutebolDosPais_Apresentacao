package br.com.futeboldospais.futeboldospais.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Suspensao;
import br.com.futeboldospais.futeboldospais.service.SuspensaoService;
import br.com.futeboldospais.futeboldospais.util.AdapterPadrao;
import br.com.futeboldospais.futeboldospais.util.ModalSuspensao;
import br.com.futeboldospais.futeboldospais.util.SuspensaoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuspensosFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 23/10/2017.
     * Cria um singleton da classe
     */
    private static SuspensosFragment fragment = null;

    public static SuspensosFragment newInstance() {
        if (fragment == null) {
            fragment = new SuspensosFragment();
        }
        return fragment;
    }

    /**
     * Created by Grazielly de Aquino em 29.10
     */
    private ListView tabelaSuspensao;
    private Suspensao[] listaSuspensao;
    private SuspensaoService suspensaoService;
    private SuspensaoAdapter adapter;

    public SuspensosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_suspensos, container, false);

        tabelaSuspensao = (ListView) view.findViewById(R.id.suspensao_tabela);

        suspensaoService = new SuspensaoService();
        listaSuspensao = suspensaoService.listarDados(getActivity().getBaseContext());

        if (listaSuspensao.length > 0) {
            adapter = new SuspensaoAdapter(listaSuspensao, getActivity());
            tabelaSuspensao.setAdapter(adapter);

        } else {
            AdapterPadrao adapterPadrao = new AdapterPadrao(getActivity(), "Opa, não tem ninguem aqui ainda!");
            tabelaSuspensao.setAdapter(adapterPadrao);
        }

        Button btnTipSuspensao = (Button) view.findViewById(R.id.btn_tip_suspensao);

        btnTipSuspensao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModalSuspensao.class);
                startActivity(intent);
            }
        });

        return view;
    }
}




















