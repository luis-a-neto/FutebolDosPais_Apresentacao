package br.com.futeboldospais.futeboldospais.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.InputStream;

import br.com.futeboldospais.futeboldospais.R;
import br.com.futeboldospais.futeboldospais.rest.FileDownloadHelper;

/**
 * Projeto:    FutebolPaisAndroid
 * Arquivo:    DocumentViewer.java
 * Autor:      Luis Andrade
 * Data:       22.09.2017
 * <p>
 * Activity de visualizador de documentos. A mesma é reutilizável, com o intuito
 * de permitir a visualização de súmulas (PDF/JPEG) e regulamentos (PDF).
 * <p>
 * O intent deverá trazer nos extras as seguintes strings:
 * - uri (o endereço/URI do documento a ser baixado)
 * - title (o título a ser exibido na janela)
 * Os mesmos nomes são utilizados pelas variáveis durante a classe.
 * <p>
 * Utiliza-se aqui uma Toolbar com o intuito de fornecer uma "barra de título" para a janela,
 * consistente com as User Interface Guidelines do Android. (Sem reinventar a roda aqui, folks!)
 * <p>
 * Dependências: com.github.barteksc:android-pdf-viewer:2.7.0 (adicionar ao build.gradle).
 * <p>
 * Histórico de modificações:
 * Data ______ Autor _________________ Resumo ___________________________________________________
 * 22.09.2017  Luis Andrade            Inicial
 **/

public class DocumentViewer extends AppCompatActivity {

    private String url;
    private PDFView pdfView;
    private TextView jogo;
    private InputStream pdfDocument;
    private LinearLayout divStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Obrigatório!
        setContentView(R.layout.activity_document_viewer); // Configura o layout

        Intent intent = getIntent(); // Traz o intent para o nosso contexto
        // Pega do intent as variáveis necessárias
        String dados = intent.getStringExtra("dados");
        url = intent.getStringExtra("url");
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Instancia a barra superior...
        setSupportActionBar(toolbar); // ...e a configura como barra superior.

        // Configura o título da janela
        toolbar.setTitle(title);
        */
        divStatus = (LinearLayout) findViewById(R.id.div_status);
        divStatus.setVisibility(View.VISIBLE);

        jogo = (TextView) findViewById(R.id.jogo);
        pdfView = (PDFView) findViewById(R.id.pdfView);

        jogo.setText(dados);
        // Joga o contexto como variável final; precisaremos disso ao chamar o FileDownloadHelper.
        // Como vamos acessar ela a partir de uma inner class, ela tem que ser final. Java, né...
        final Context context = this;

        // Aqui é que a onça bebe água. Instancia uma nova thread runnable...
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Baixa o PDF.
                            pdfDocument =
                                    FileDownloadHelper.downloadBinary(context, url);

                            // Pega o PDF baixado e o exibe na PDFView da activity.
                            runOnUiThread(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            divStatus.setVisibility(View.INVISIBLE);
                                            // Exibe o PDF.
                                            pdfView.fromStream(pdfDocument)
                                                    .enableAnnotationRendering(true)
                                                    .spacing(0) // in dp
                                                    .load();
                                        }
                                    }
                            );
                        } catch (Exception e) {
                            runOnUiThread(
                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            divStatus.setVisibility(View.INVISIBLE);
                                            Toast.makeText(getBaseContext(), "Ocorreu um erro ao carregar a súmula", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                    }
                            );
                        }
                    }
                }
        ).start();
    }

    public void voltar(View view){
        finish();
    }
}
