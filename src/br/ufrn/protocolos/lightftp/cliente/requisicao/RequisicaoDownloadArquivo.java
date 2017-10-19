package br.ufrn.protocolos.lightftp.cliente.requisicao;

import br.ufrn.protocolos.lightftp.arquivo.ManipulaArquivo;

public class RequisicaoDownloadArquivo {
	
	public String preparaMensagemRequisicao(String nomeArquivo) {
		String mensagemRequisicao = "";
		mensagemRequisicao = TipoRequisicao.SOLICITACAO_DOWNLOAD_ARQUIVO + "\n";
		mensagemRequisicao += ManipulaArquivo.DIRETORIO_REMOTO_CLIENTE + "\n"; 
		mensagemRequisicao += nomeArquivo;
		return mensagemRequisicao;
	}
}
