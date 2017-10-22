package br.ufrn.protocolos.lightftp.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoUploadArquivo;

public class Cliente {
	
	public void inicializaCliente() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		
		RequisicaoUploadArquivo requisicaoUploadArquivo = new RequisicaoUploadArquivo("arquivorecebido.txt");
		byte[] dados = requisicaoUploadArquivo.preparaBytesRequisicao();
		outBytes.write(dados);

//		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
//		byte[] data = new byte[1024];
//		inBytes.read(data);

		socket.close();
	}
}
