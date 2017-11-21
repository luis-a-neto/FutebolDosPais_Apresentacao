package br.com.futeboldospais.futeboldospais.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisAdapterDireita;
import br.com.futeboldospais.futeboldospais.util.QuartasFinaisAdapterEsquerda;

/**
 * Created by Pâmela Fidelis on 11/11/17.
 */

public class QuartasFinaisFragmentMaster extends Fragment {


    private ListView tabela_esq;
    private ListView tabela_dir;

    private Classificacao[] lista;
    private ClassificacaoQuartasService quartasFinaisService;
    private QuartasFinaisAdapterEsquerda adapterEsq;
    private QuartasFinaisAdapterDireita adapterDir;

    private static String categoria;
    private static String grupo;

    public static final String CLASSIFICACAO = "br.com.futeboldospais.futeboldospais.model.Classificacao";

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe e pega a categoria e grupo
     */
    private static QuartasFinaisFragmentMaster fragment = null;

    public static QuartasFinaisFragmentMaster newInstance() {
        if (fragment == null) {
            fragment = new QuartasFinaisFragmentMaster();
        }

   /*     Bundle args = new Bundle();
        args.putString("categoria", categoria);
        args.putString("grupo", grupo);
        fragment.setArguments(args);
*/
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("quartas", "Entrou no Master");
        final View view = inflater.inflate(R.layout.fragment_quartas_finais_master, container, false);

        Bundle args = getArguments();

        grupo = args.getString("grupo");

        quartasFinaisService = new ClassificacaoQuartasService();

        tabela_esq = (ListView) view.findViewById(R.id.quartas_tabela_esq);
        tabela_dir = (ListView) view.findViewById(R.id.quartas_tabela_dir);

        lista = quartasFinaisService.listarQuartasPorCategoriaGrupo(getActivity()
                .getBaseContext(), "Master", grupo);




        Log.d("quartas", "Lista master " + lista.toString());
        Log.d("quartas", "criou os jogos");

        adapterEsq = new QuartasFinaisAdapterEsquerda(lista, getActivity());
        tabela_esq.setAdapter(adapterEsq);
        setListViewHeightBasedOnChildren(tabela_esq);
        Log.d("quartas", "criou a tabela da esquerda");

        adapterDir = new QuartasFinaisAdapterDireita(lista, getActivity());
        tabela_dir.setAdapter(adapterDir);
        setListViewHeightBasedOnChildren(tabela_dir);
        Log.d("quartas", "criou a tabela da direita");

        // Inflate the layout for this fragment */
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
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}