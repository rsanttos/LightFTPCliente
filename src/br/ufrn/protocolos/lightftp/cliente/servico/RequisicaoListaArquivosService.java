package br.ufrn.protocolos.lightftp.cliente.servico;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoListaArquivos;

public class RequisicaoListaArquivosService {
	
	
	public RequisicaoListaArquivosService() {
		super();
	}


	public void realizaRequisicao() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		RequisicaoListaArquivos requisicaoListaArquivos = new RequisicaoListaArquivos();
		String mensagem = requisicaoListaArquivos.preparaMensagemRequisicao();
		outBytes.write(mensagem.getBytes());
		
		requisicaoListaArquivos.recebeResposta(socket);

		socket.close();
	}
}
