package br.com.futeboldospais.futeboldospais.service;

import java.util.List;

import br.com.futeboldospais.futeboldospais.model.Artilharia;
import br.com.futeboldospais.futeboldospais.model.Atualizacao;
import br.com.futeboldospais.futeboldospais.model.Cartao;
import br.com.futeboldospais.futeboldospais.model.Classificacao;
import br.com.futeboldospais.futeboldospais.model.ClassificacaoQuartas;
import br.com.futeboldospais.futeboldospais.model.Configuracao;
import br.com.futeboldospais.futeboldospais.model.Resultado;
import br.com.futeboldospais.futeboldospais.model.Suspensao;

/**
 * Created by ThirdSystem on 12/11/2017.
 */

public abstract class AtualizacaoServiceInterface {

    protected ConfiguracaoService configuracaoService;
    protected DistintivoService distintivoService;
    protected ClassificacaoService classificacaoService;
    protected ArtilhariaService artilhariaService;
    protected CartaoService cartaoService;
    protected SuspensaoService suspensaoService;
    protected ResultadoService resultadoService;
    protected ClassificacaoQuartasService classificacaoQuartasService;
    protected Atualizacao atualizacao;
    protected Configuracao configuracaoServidor;

    protected List<Classificacao> listaClassificacao = null;
    protected List<Artilharia> listaArtilharia;
    protected List<Cartao> listaCartaoAmarelo;
    protected List<Cartao> listaCartaoVermelho;
    protected List<Suspensao> listaSuspensao;
    protected List<Resultado> listaResutado;
    protected List<Resultado> listaJogo;
    protected List<ClassificacaoQuartas> listaClassificacaoQuartas;
    //protected List<Jogo> listaJogo;

    protected AtualizacaoServiceInterface(){
        atualizacao = new Atualizacao();
    }

    public abstract int verificarAtualizacao();

    public abstract boolean executarAtualizacaoPorTipo();

    public abstract boolean atualizarDados(int campeonatoAnoLocal) throws Exception;
}
