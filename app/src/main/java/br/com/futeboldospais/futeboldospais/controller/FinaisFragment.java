package br.com.futeboldospais.futeboldospais.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.service.ClassificacaoQuartasService;
import br.com.futeboldospais.futeboldospais.service.DistintivoService;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinaisFragment extends Fragment {

    /**
     * Created by Daniel Almeida on 08/09/2017.
     * Cria um singleton da classe
     */
    private static FinaisFragment fragment = null;

    public static FinaisFragment newInstance() {
        if (fragment == null) {
            fragment = new FinaisFragment();
        }
        return fragment;
    }

    private ImageView imgMasterPrincipal1;
    private TextView txtMasterPrincipal1;
    private TextView golsMasterPrincipal1;

    private ImageView imgMasterRepescagem1;
    private TextView txtMasterRepescagem1;
    private TextView golsMasterRepescagem1;

    private ImageView imgMasterPrincipal2;
    private TextView txtMasterPrincipal2;
    private TextView golsMasterPrincipal2;

    private ImageView imgMasterPrincipal3;
    private TextView txtMasterPrincipal3;
    private TextView golsMasterPrincipal3;

    private ImageView imgSeniorPrincipal1;
    private TextView txtSeniorPrincipal1;
    private TextView golsSeniorPrincipal1;

    private ImageView imgSeniorRepescagem1;
    private TextView txtSeniorRepescagem1;
    private TextView golsSeniorRepescagem1;

    private ImageView imgSeniorPrincipal2;
    private TextView txtSeniorPrincipal2;
    private TextView golsSeniorPrincipal2;

    private ImageView imgSeniorPrincipal3;
    private TextView txtSeniorPrincipal3;
    private TextView golsSeniorPrincipal3;

    ClassificacaoQuartasService classificacaoQuartasService;
    DistintivoService distintivoService;

    public FinaisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finais, container, false);

        imgMasterPrincipal1 = (ImageView) view.findViewById(R.id.img_master_principal_1);
        txtMasterPrincipal1 = (TextView) view.findViewById(R.id.txt_master_principal_1);
        golsMasterPrincipal1 = (TextView) view.findViewById(R.id.gols_master_principal_1);

        imgMasterRepescagem1 = (ImageView) view.findViewById(R.id.img_master_repescagem_1);
        txtMasterRepescagem1 = (TextView) view.findViewById(R.id.txt_master_repescagem_1);
        golsMasterRepescagem1 = (TextView) view.findViewById(R.id.gols_master_repescagem_1);

        imgMasterPrincipal2 = (ImageView) view.findViewById(R.id.img_master_principal_2);
        txtMasterPrincipal2 = (TextView) view.findViewById(R.id.txt_master_principal_2);
        golsMasterPrincipal2 = (TextView) view.findViewById(R.id.gols_master_principal_2);

        imgMasterPrincipal3 = (ImageView) view.findViewById(R.id.img_master_principal_3);
        txtMasterPrincipal3 = (TextView) view.findViewById(R.id.txt_master_principal_3);
        golsMasterPrincipal3 = (TextView) view.findViewById(R.id.gols_master_principal_3);

        imgSeniorPrincipal1 = (ImageView) view.findViewById(R.id.img_senior_principal_1);
        txtSeniorPrincipal1 = (TextView) view.findViewById(R.id.txt_senior_principal_1);
        golsSeniorPrincipal1 = (TextView) view.findViewById(R.id.gols_senior_principal_1);

        imgSeniorRepescagem1 = (ImageView) view.findViewById(R.id.img_senior_repescagem_1);
        txtSeniorRepescagem1 = (TextView) view.findViewById(R.id.txt_senior_repescagem_1);
        golsSeniorRepescagem1 = (TextView) view.findViewById(R.id.gols_senior_repescagem_1);

        imgSeniorPrincipal2 = (ImageView) view.findViewById(R.id.img_senior_principal_2);
        txtSeniorPrincipal2 = (TextView) view.findViewById(R.id.txt_senior_principal_2);
        golsSeniorPrincipal2 = (TextView) view.findViewById(R.id.gols_senior_principal_2);

        imgSeniorPrincipal3 = (ImageView) view.findViewById(R.id.img_senior_principal_3);
        txtSeniorPrincipal3  = (TextView) view.findViewById(R.id.txt_senior_principal_3);
        golsSeniorPrincipal3 = (TextView) view.findViewById(R.id.gols_senior_principal_3);

        classificacaoQuartasService = new ClassificacaoQuartasService();
        distintivoService = new DistintivoService();
        String equipe;

        try {
            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Master", "Principal", 1);
            imgMasterPrincipal1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtMasterPrincipal1.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Master", "Repescagem", 1);
            imgMasterRepescagem1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtMasterRepescagem1.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Master", "Principal", 2);
            imgMasterPrincipal2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtMasterPrincipal2.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Master", "Principal", 3);
            imgMasterPrincipal3.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtMasterPrincipal3.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Senior", "Principal", 1);
            imgSeniorPrincipal1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtSeniorPrincipal1.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Senior", "Repescagem", 1);
            imgSeniorRepescagem1.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtSeniorRepescagem1.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Senior", "Principal", 2);
            imgSeniorPrincipal2.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtSeniorPrincipal2.setText(equipe);

            equipe = classificacaoQuartasService.buscarEquipeNaPosicao(getActivity().getBaseContext(), "Senior", "Principal", 3);
            imgSeniorPrincipal3.setImageBitmap(distintivoService.carregarImagemDoArmazenamentoInterno(distintivoService.getDiretorio(), equipe));
            txtSeniorPrincipal3.setText(equipe);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }

}
