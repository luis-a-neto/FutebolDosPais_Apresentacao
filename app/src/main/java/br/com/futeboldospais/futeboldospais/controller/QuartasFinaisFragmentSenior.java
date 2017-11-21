package br.com.futeboldospais.futeboldospais.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class QuartasFinaisFragmentSenior extends Fragment{


    private ListView tabela_esq;
    private ListView tabela_dir;

    private Classificacao[] lista_quartas;
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
    private static QuartasFinaisFragmentSenior fragment = null;

    public static QuartasFinaisFragmentSenior newInstance() {
        if (fragment == null) {
            fragment = new QuartasFinaisFragmentSenior();
        }

   /*     Bundle args = new Bundle();
        args.putString("categoria", categoria);
        args.putString("grupo", grupo);
        fragment.setArguments(args);
*/
        return fragment;
    }

    public QuartasFinaisFragmentSenior() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("quartas", "Entrou no Sênior");
        final View view = inflater.inflate(R.layout.fragment_quartas_finais_senior, container, false);

        Bundle args = getArguments();
        grupo = args.getString("grupo");

        quartasFinaisService = new ClassificacaoQuartasService();

        tabela_esq = (ListView) view.findViewById(R.id.quartas_tabela_esq);
        tabela_dir = (ListView) view.findViewById(R.id.quartas_tabela_dir);

        lista_quartas = quartasFinaisService.listarQuartasPorCategoriaGrupo(getActivity()
                .getBaseContext(), "Senior", grupo);

        Log.d("quartas", "Lista senior " + lista_quartas.toString());
        Log.d("quarta", "criou os jogos");

        adapterEsq = new QuartasFinaisAdapterEsquerda(lista_quartas, getActivity());
        tabela_esq.setAdapter(adapterEsq);
        setListViewHeightBasedOnChildren(tabela_esq);
        Log.d("quarta", "criou a tabela da esquerda");

        adapterDir = new QuartasFinaisAdapterDireita(lista_quartas, getActivity());
        tabela_dir.setAdapter(adapterDir);
        setListViewHeightBasedOnChildren(tabela_dir);
        Log.d("quarta", "criou a tabela da direita");

        tabela_esq.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d("quarta", "criou o time");
//                Intent intent = new Intent(getActivity(), TimeActivity.class);
//                intent.putExtra(CLASSIFICACAO, lista_quartas[position]);
//                intent.putExtra("Posicao", position);
//                startActivity(intent);
            }

        });

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