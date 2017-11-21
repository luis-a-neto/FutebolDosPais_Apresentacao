package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by Pamela Fidelis on 15/11/17.
 */

public class QuartasFinaisAdapterEsquerda extends BaseAdapter{


    private DistintivoService distintivoService;
    private Classificacao[] listaClassificacao;
    private Context context;

    public QuartasFinaisAdapterEsquerda(Classificacao[] classificacaos, Context context){
        Log.d("quartas", "ClassificacaoAdapterEsquerda");
        this.listaClassificacao = classificacaos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaClassificacao.length;
    }

    @Override
    public Object getItem(int position) {
        return listaClassificacao[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.linha_quartas_finais_esq, parent, false);

            TextView posicao = (TextView) view.findViewById(R.id.posicao);
            ImageView escudo = (ImageView) view.findViewById(R.id.escudo);
            TextView equipe = (TextView) view.findViewById(R.id.equipe);

            ViewHolderQuartasFinaisEsquerda viewHolderQuartasFinaisEsquerda
                    = new ViewHolderQuartasFinaisEsquerda(posicao, escudo, equipe);

            view.setTag(viewHolderQuartasFinaisEsquerda);

            distintivoService = new DistintivoService();
        }

        ViewHolderQuartasFinaisEsquerda viewHolderQuartasFinaisEsquerda
                = (ViewHolderQuartasFinaisEsquerda)view.getTag();
        viewHolderQuartasFinaisEsquerda.getPosicao()
                .setText(String.valueOf(position + 1) + "º");

        try {
            viewHolderQuartasFinaisEsquerda.getEscudo().setImageBitmap(distintivoService
                    .carregarImagemDoArmazenamentoInterno(distintivoService
                            .getDiretorio(), listaClassificacao[position]
                            .getEquipe()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolderQuartasFinaisEsquerda
                .getEquipe()
                .setText(listaClassificacao[position]
                        .getEquipe());

        return view;
    }

}
