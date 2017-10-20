package br.ufrn.protocolos.lightftp.cliente.requisicao;

import java.io.File;

import br.ufrn.protocolos.lightftp.arquivo.ManipulaArquivo;

public class RequisicaoUploadArquivo extends RequisicaoGenerica {

	private String nomeArquivo;
	

	public RequisicaoUploadArquivo(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
		preparaMensagemRequisicao();
	}

	public RequisicaoUploadArquivo(String status, String mensagemRequisicao, String nomeArquivo) {
		super(status, mensagemRequisicao);
		// TODO Auto-generated constructor stub
	}

	private void preparaMensagemRequisicao() {
		mensagemRequisicao = "";
		mensagemRequisicao += TipoRequisicao.SOLICITACAO_UPLOAD_ARQUIVO + "\n";
		mensagemRequisicao += nomeArquivo;
	}

	
	@Override
	public void entenderMensagemRequisicao() {
		// TODO Auto-generated method stub
		super.entenderMensagemRequisicao();
		nomeArquivo = dadosMensagem[2];
	}

	public byte[] preparaBytesRequisicao() {
		File arquivoParaEnvio = new File(nomeArquivo);
		byte[] bytesArquivo = ManipulaArquivo.transformaArquivoEmBytes(arquivoParaEnvio);
		byte[] bytesRequisicao = concatenaArraysBytes(mensagemRequisicao.getBytes(), bytesArquivo);
		return bytesRequisicao;
	}
	
	public byte[] concatenaArraysBytes(byte[] inicio, byte[] fim) {
		byte[] arrayCompleto = new byte[inicio.length + fim.length];
		
		for(int i = 0 ; i < inicio.length ; i++) {
			arrayCompleto[i] = inicio[i];
		}
		
		int i = inicio.length;
		for(int j = 0 ; j < fim.length ; j++, i++) {
			arrayCompleto[i] = fim[j];
		} 
		
		return arrayCompleto;
	}
}
