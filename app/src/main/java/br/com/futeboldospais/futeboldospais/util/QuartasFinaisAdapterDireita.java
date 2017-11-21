package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Classificacao;

/**
 * Created by Pamela Fidelis on 12/11/2017.
 */

public class QuartasFinaisAdapterDireita extends BaseAdapter {

    private Classificacao[] quartasFinais;
    private Context context;

    public QuartasFinaisAdapterDireita(Classificacao[] classificacao, Context context) {
        this.quartasFinais = classificacao;
        this.context = context;
    }

    @Override
    public int getCount() {
        return quartasFinais.length;
    }

    @Override
    public Object getItem(int position) {
        return quartasFinais[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.linha_quartas_finais_dir, parent, false);

            TextView pontosGanhos = (TextView) view.findViewById(R.id.pontos_ganhos);
            TextView jogos = (TextView) view.findViewById(R.id.jogos);
            TextView vitorias = (TextView) view.findViewById(R.id.vitorias);
            TextView saldoGols = (TextView) view.findViewById(R.id.saldo_gols);

            ViewHolderQuartasFinaisDireita viewHolder
                    = new ViewHolderQuartasFinaisDireita(pontosGanhos, jogos, vitorias, saldoGols);

            view.setTag(viewHolder);
        }
        ViewHolderQuartasFinaisDireita viewHolder = (ViewHolderQuartasFinaisDireita) view.getTag();

        viewHolder.getPontosGanhos()
                .setText(String.valueOf(quartasFinais[position]
                        .getPontosGanhos()));

        viewHolder.getJogos()
                .setText(String.valueOf(quartasFinais[position]
                        .getJogos()));

        viewHolder.getVitorias()
                .setText(String.valueOf(quartasFinais[position]
                        .getVitorias()));
        viewHolder.getSaldoGols()
                .setText(String.valueOf(quartasFinais[position]
                        .getSaldoGols()));

        return view;
    }
}
