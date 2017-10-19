package br.ufrn.protocolos.lightftp.cliente.main;

import java.io.IOException;

import br.ufrn.protocolos.lightftp.cliente.Cliente;

public class ClienteMain {
	public static void main(String[] args) throws IOException {
		Cliente cliente = new Cliente();
		cliente.inicializaCliente();
	}
}
