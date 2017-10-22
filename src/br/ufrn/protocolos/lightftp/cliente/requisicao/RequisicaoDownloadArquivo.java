package br.ufrn.protocolos.lightftp.cliente.requisicao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.servico.lista.Lista;
import br.com.servico.manipulaarquivo.Arquivo;
import br.com.servico.mensagem.MensagemServico;

public class RequisicaoDownloadArquivo extends RequisicaoGenerica {
	private List<Byte> status;
	private List<Byte> tamanhoArquivo;
	private List<Byte> arquivo;
	private MensagemServico mensagemServico;
	
	private String nomeArquivo;	
	
	public RequisicaoDownloadArquivo(String nomeArquivo) {
		super();
		this.status = new ArrayList<Byte>();
		this.tamanhoArquivo = new ArrayList<Byte>();
		this.arquivo = new ArrayList<Byte>();
		this.mensagemServico = new MensagemServico();
		this.nomeArquivo = nomeArquivo;
	}

	public RequisicaoDownloadArquivo(String status, String mensagemRequisicao) {
		super(status, mensagemRequisicao);
		this.status = new ArrayList<Byte>();
		this.tamanhoArquivo = new ArrayList<Byte>();
		this.arquivo = new ArrayList<Byte>();
		this.mensagemServico = new MensagemServico();
		// TODO Auto-generated constructor stub
	}

	public String preparaMensagemRequisicao() {
		mensagemRequisicao = "";
		mensagemRequisicao = TipoRequisicao.SOLICITACAO_DOWNLOAD_ARQUIVO + "\n";
		mensagemRequisicao += nomeArquivo;
		return mensagemRequisicao;
	}
	
	public void recebeDados(byte[] dados) {
	
		int i = 0;
		while(dados[i] != '\n') {
			status.add(dados[i]);
			i++;
		}
		
		status.add(dados[i]);
		
		i++;
		while(dados[i] != '\n') {
			tamanhoArquivo.add(dados[i]);
			i++;
		}		
		
		byte[] tamanho = Lista.dinamicoParaEstatico(tamanhoArquivo);
		String tamanhoStr = new String(tamanho);
		int tamanhoArquivo = Integer.parseInt(tamanhoStr);
		
		i++;
		int j = 0;
		while(j < tamanhoArquivo) {
			arquivo.add(dados[i]);
			i++;
			j++;
		}	
	}
	
	public void criaArquivo() throws IOException {
		entenderMensagemRequisicao();
		byte[] arquivoBytes = Lista.dinamicoParaEstatico(arquivo);
		File arquivo = Arquivo.byteToFile(arquivoBytes, nomeArquivo);
	}
}
