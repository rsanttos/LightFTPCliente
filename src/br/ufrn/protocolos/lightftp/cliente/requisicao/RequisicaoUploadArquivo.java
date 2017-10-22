package br.ufrn.protocolos.lightftp.cliente.requisicao;

import java.io.File;

import br.com.servico.manipulaarquivo.Arquivo;
import br.com.servico.mensagem.MensagemServico;

public class RequisicaoUploadArquivo extends RequisicaoGenerica {

	private String nomeArquivo;
	private int tamanhoArquivo;
	private byte[] bytesArquivo;
	
	private MensagemServico mensagemServico;
	

	public RequisicaoUploadArquivo(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
		this.mensagemServico = new MensagemServico();
	}

	public RequisicaoUploadArquivo(String status, String mensagemRequisicao, String nomeArquivo) {
		super(status, mensagemRequisicao);
		this.mensagemServico = new MensagemServico();
	}

	private String preparaCabecalho() {
		mensagemRequisicao = "";
		mensagemRequisicao += TipoRequisicao.SOLICITACAO_UPLOAD_ARQUIVO + "\n";
		mensagemRequisicao += nomeArquivo + "\n";
		return mensagemRequisicao;
	}

	
	@Override
	public void entenderMensagemRequisicao() {
		// TODO Auto-generated method stub
		super.entenderMensagemRequisicao();
		nomeArquivo = dadosMensagem[2];
	}

	public byte[] preparaBytesRequisicao() {
		String cabecalho = preparaCabecalho();
		File arquivoParaEnvio = new File(nomeArquivo);
		byte[] bytesArquivo = Arquivo.fileToByte(arquivoParaEnvio);
		
		cabecalho += bytesArquivo.length + "\n";
		
		byte[] bytesRequisicao = mensagemServico.concatenaArraysBytes(cabecalho.getBytes(), bytesArquivo);

		return bytesRequisicao;
	}
	
}
