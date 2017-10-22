package br.ufrn.protocolos.lightftp.cliente.requisicao;

public class RequisicaoListaArquivos extends RequisicaoGenerica {

	public RequisicaoListaArquivos() {
		super();
	}
	
	public String preparaMensagemRequisicao() {
		String mensagemRequisicao = "";
		mensagemRequisicao = TipoRequisicao.SOLICITACAO_LISTA_ARQUIVOS + "\n";
		return mensagemRequisicao;
	}

}
