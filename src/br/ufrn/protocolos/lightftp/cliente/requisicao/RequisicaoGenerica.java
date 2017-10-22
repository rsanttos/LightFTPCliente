package br.ufrn.protocolos.lightftp.cliente.requisicao;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RequisicaoGenerica {
	
	protected String status;
	protected String mensagemRequisicao;
	protected String mensagemResposta;
	protected String tipoRequisicao;
	protected String[] dadosMensagem;
	
	public RequisicaoGenerica() {
		this.mensagemRequisicao = "";
		this.mensagemResposta = ";";
		this.status = "";
	}
	public RequisicaoGenerica(String status, String mensagemRequisicao, String mensagemResposta) {
		super();
		this.status = status;
		this.mensagemRequisicao = mensagemRequisicao;
		this.mensagemResposta = mensagemResposta;
	}
	public RequisicaoGenerica(String status, String mensagemRequisicao) {
		super();
		this.status = status;
		this.mensagemRequisicao = mensagemRequisicao;
	}	
	
	public void entenderMensagemRequisicao() {
		dadosMensagem = mensagemRequisicao.split("\n");
		tipoRequisicao = dadosMensagem[0];	
	}

	
	public void recebeResposta(Socket socket) throws IOException {
		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		byte[] data = new byte[128];
		inBytes.read(data);
		String mensagemRecebida = new String(data).trim();
		System.out.println(mensagemRecebida);		
	}
}
