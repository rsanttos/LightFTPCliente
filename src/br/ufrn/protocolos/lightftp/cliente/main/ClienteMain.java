package br.ufrn.protocolos.lightftp.cliente.main;

import java.io.IOException;

import br.ufrn.protocolos.lightftp.cliente.servico.RequisicaoUploadArquivoService;

public class ClienteMain {
	public static void main(String[] args) throws IOException {
		// RequisicaoDownloadArquivoService requisicaoDownloadArquivoService = new
		// RequisicaoDownloadArquivoService("casa.jpg");
		// requisicaoDownloadArquivoService.realizaRequisicao();

		RequisicaoUploadArquivoService requisicaoUploadService = new RequisicaoUploadArquivoService("casa.jpg");
		requisicaoUploadService.realizaRequisicao();

		// RequisicaoListaArquivosService requisicaoListaArquivosService = new
		// RequisicaoListaArquivosService();
		// requisicaoListaArquivosService.realizaRequisicao();
	}
}
