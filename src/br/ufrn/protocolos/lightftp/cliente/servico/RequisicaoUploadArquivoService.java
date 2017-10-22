package br.ufrn.protocolos.lightftp.cliente.servico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoDownloadArquivo;
import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoUploadArquivo;


public class RequisicaoUploadArquivoService {
	
	private String nomeArquivo;
	
	private static int LIMITE_TAMANHO_ARQUIVO = 2000000;
	
	public RequisicaoUploadArquivoService(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}


	public void realizaRequisicao() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		
		RequisicaoUploadArquivo requisicaoUploadArquivo = new RequisicaoUploadArquivo(nomeArquivo);
		outBytes.write(requisicaoUploadArquivo.preparaBytesRequisicao());
		
		requisicaoUploadArquivo.recebeResposta(socket);

		socket.close();
	}
}
