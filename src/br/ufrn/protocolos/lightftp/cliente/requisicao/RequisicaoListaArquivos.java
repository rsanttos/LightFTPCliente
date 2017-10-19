package br.ufrn.protocolos.lightftp.cliente.requisicao;

import br.ufrn.protocolos.lightftp.arquivo.ManipulaArquivo;

public class RequisicaoListaArquivos {

	public RequisicaoListaArquivos() {
		super();
	}
	
	public String preparaMensagemRequisicao() {
		String mensagemRequisicao = "";
		mensagemRequisicao = TipoRequisicao.SOLICITACAO_LISTA_ARQUIVOS + "\n";
		mensagemRequisicao += ManipulaArquivo.DIRETORIO_REMOTO_CLIENTE + "\n"; 
		return mensagemRequisicao;
	}
	
	public void recebeResposta(String mensagem) {
		
	}

}
