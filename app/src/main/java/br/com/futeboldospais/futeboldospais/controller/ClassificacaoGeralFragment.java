package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoService;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterDireita;
import br.com.futeboldospais.futeboldospais.util.ClassificacaoAdapterEsquerda;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassificacaoGeralFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static ClassificacaoGeralFragment fragment = null;

    public static ClassificacaoGeralFragment newInstance() {
        if (fragment == null) {
            fragment = new ClassificacaoGeralFragment();
        }
        return fragment;
    }

    private ListView tabelaClassificacaoEsq;
    private ListView tabelaClassificacaoDir;
    private Classificacao[] listaClassificacao;
    private ClassificacaoService classificacaoService;
    private ClassificacaoAdapterEsquerda adapterEsq;
    private ClassificacaoAdapterDireita adapterDir;

    public ClassificacaoGeralFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_classificacao_geral, container, false);


        tabelaClassificacaoEsq = (ListView) view.findViewById(R.id.classificacao_tabela_esq);
        tabelaClassificacaoDir = (ListView) view.findViewById(R.id.classificacao_tabela_dir);
        Log.d("teste", "adapter fragment");


        classificacaoService = new ClassificacaoService();
        listaClassificacao = classificacaoService.listarDados(getActivity().getBaseContext());

        adapterDir = new ClassificacaoAdapterDireita(listaClassificacao, getActivity());
        tabelaClassificacaoDir.setAdapter(adapterDir);
        setListViewHeightBasedOnChildren(tabelaClassificacaoDir);

        adapterEsq = new ClassificacaoAdapterEsquerda(listaClassificacao, getActivity());
        tabelaClassificacaoEsq.setAdapter(adapterEsq);
        setListViewHeightBasedOnChildren(tabelaClassificacaoEsq);

        return view;
    }

    /**** Method for Setting the Height of the ListView dynamically.
     **** Hack to fix the issue of not showing all the items of the ListView
     **** when placed inside a ScrollView  ****/
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
