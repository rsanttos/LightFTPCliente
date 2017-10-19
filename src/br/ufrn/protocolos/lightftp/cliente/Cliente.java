package br.ufrn.protocolos.lightftp.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoDownloadArquivo;
import br.ufrn.protocolos.lightftp.cliente.requisicao.RequisicaoListaArquivos;

public class Cliente {
	
	public void inicializaCliente() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7777);
		System.out.println("Cliente conectado com o servidor " + socket.getInetAddress().getHostAddress() + ":"
				+ socket.getPort());

		DataOutputStream outBytes = new DataOutputStream(socket.getOutputStream());
		
		String mensagem = new RequisicaoDownloadArquivo().preparaMensagemRequisicao("protocolo.txt");
		outBytes.write(mensagem.getBytes());

		DataInputStream inBytes = new DataInputStream(socket.getInputStream());
		byte[] data = new byte[1024];
		inBytes.read(data);
		
		String mensagemRecebida = new String(data);		
		String[] dadosMensagem = mensagemRecebida.split("\n");	
		String[] strBytesArquivo = dadosMensagem[1].split(";");	
		
		byte[] bytesArquivo;
		
		System.out.println(mensagemRecebida);

		socket.close();
	}
}
