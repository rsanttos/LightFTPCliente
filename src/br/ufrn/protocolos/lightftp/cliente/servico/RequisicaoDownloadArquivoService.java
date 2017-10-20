package br.ufrn.protocolos.lightftp.cliente.servico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoDownloadArquivo;

public class RequisicaoDownloadArquivoService {
	
	private String nomeArquivo;
	
	
	
	public RequisicaoDownloadArquivoService(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}


	public void realizaRequisicao() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		
		RequisicaoDownloadArquivo requisicaoDownloadArquivo = new RequisicaoDownloadArquivo(nomeArquivo);
		String mensagem = requisicaoDownloadArquivo.preparaMensagemRequisicao();
		outBytes.write(mensagem.getBytes());

		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		byte[] data = new byte[1024];
		inBytes.read(data);
		
		requisicaoDownloadArquivo.recebeDados(data);
		requisicaoDownloadArquivo.criaArquivo();

		socket.close();
	}
}
