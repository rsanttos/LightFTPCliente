package br.ufrn.protocolos.lightftp.cliente.requisicao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.protocolos.lightftp.arquivo.ManipulaArquivo;

public class RequisicaoDownloadArquivo extends RequisicaoGenerica {
	private List<Byte> status;
	private List<Byte> arquivo;
	
	private String nomeArquivo;	
	
	public RequisicaoDownloadArquivo(String nomeArquivo) {
		super();
		this.status = new ArrayList<Byte>();
		this.arquivo = new ArrayList<Byte>();
		this.nomeArquivo = nomeArquivo;
	}

	public RequisicaoDownloadArquivo(String status, String mensagemRequisicao) {
		super(status, mensagemRequisicao);
		this.status = new ArrayList<Byte>();
		this.arquivo = new ArrayList<Byte>();
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
		int j = 0;
		while(dados[i] != 0) {
			arquivo.add(dados[i]);
			j++;
			i++;
		}	
	}
	
	public void criaArquivo() throws IOException {
		entenderMensagemRequisicao();
		byte[] arquivoBytes = ManipulaArquivo.transformaArrayDinamicoEmEstatico(arquivo);
		ManipulaArquivo.transformaBytesEmArquivo(arquivoBytes, nomeArquivo);
	}
}
