package br.com.futeboldospais.futeboldospais.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.model.Suspensao;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * Created by Grazielly on 29/10/2017.
 */

public class SuspensaoAdapter extends BaseAdapter {

    private DistintivoService distintivoService;
    private Suspensao[] listaSuspensao;
    private Context context;

    public SuspensaoAdapter(Suspensao[] suspensaos, Context context) {
        Log.d( "teste", "construtor" );
        this.listaSuspensao = suspensaos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaSuspensao.length;
    }

    @Override
    public Object getItem(int position) {
        return listaSuspensao[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {

            Log.d( "teste", "hahahaha" );
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            Log.d( "teste", "Embaixo do inflater" );
            view = inflater.inflate( R.layout.linha_suspensos, parent, false );

            ImageView escudo = (ImageView) view.findViewById( R.id.escudo );
            TextView jogador = (TextView) view.findViewById( R.id.jogador );
            TextView numero = (TextView) view.findViewById( R.id.numero );
            TextView categoria = (TextView) view.findViewById(R.id.categoria);
            TextView criterio = (TextView) view.findViewById( R.id.criterio );
            TextView jogos = (TextView) view.findViewById( R.id.jogos );
            ImageView motivo = (ImageView) view.findViewById( R.id.motivo );
            Log.d( "teste", "Abaixo dos Find" );

            ViewHolderSuspensao viewHolderSuspensao = new ViewHolderSuspensao( escudo, jogador, numero, categoria, criterio, jogos, motivo );
            Log.d( "teste", "Abaixo do viewholder" );

            view.setTag( viewHolderSuspensao );
            Log.d( "teste", "Seto a tag" );
        }

        distintivoService = new DistintivoService();

        ViewHolderSuspensao viewHolderSuspensao = (ViewHolderSuspensao) view.getTag();
        Log.d( "teste", "Pego a tag" );
        try {

            viewHolderSuspensao.getEscudo().setImageBitmap( distintivoService.carregarImagemDoArmazenamentoInterno( distintivoService.getDiretorio(), listaSuspensao[position].getEquipe() ) );
        } catch (Exception e) {
            e.printStackTrace();
        }

        viewHolderSuspensao.getJogador().setText( String.valueOf( listaSuspensao[position].getJogador() ) );
        Log.d( "teste", "Carregou o viewholder 2" );

        viewHolderSuspensao.getNumero().setText( String.valueOf( listaSuspensao[position].getNumero() ) );
        Log.d( "teste", "Carregou o viewholder 3" );

        viewHolderSuspensao.getCategoria().setText(listaSuspensao[position].getCategoria().toUpperCase());

        Log.d( "teste", "CRITERIOOOOOOOOOOOO: " + listaSuspensao[position].getCriterio());

        viewHolderSuspensao.getCriterio().setText( String.valueOf( listaSuspensao[position].getCriterio() ) );
        Log.d( "teste", "Carregou o viewholder 4" );

        viewHolderSuspensao.getJogos().setText( String.valueOf( listaSuspensao[position].getJogos() ) );
        Log.d( "teste", "Carregou o viewholder 5" );


        if (listaSuspensao[position].getMotivo().equals( "cartao amarelo" )) {
            viewHolderSuspensao.getMotivo().setImageDrawable( ContextCompat.getDrawable( context, R.drawable.ic_cartaoamarelo ) );

        } else if (listaSuspensao[position].getMotivo().equals( "cartao vermelho" )) {
            viewHolderSuspensao.getMotivo().setImageDrawable( ContextCompat.getDrawable( context, R.drawable.ic_cartaovermelho ) );

        } else if (listaSuspensao[position].getMotivo().equals( "julgamento" )) {
            viewHolderSuspensao.getMotivo().setImageDrawable( ContextCompat.getDrawable( context, R.drawable.ic_julgamento ) );
        }


            Log.d( "teste", "Carregou o viewholder final" );

            // viewHolderSuspensao.getMotivo().setImageDrawable(drawable);

            return view;

        }
    }



