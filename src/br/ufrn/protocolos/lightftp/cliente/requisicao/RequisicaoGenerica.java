package br.ufrn.protocolos.lightftp.cliente.requisicao;

public class RequisicaoGenerica {
	
	protected String status;
	protected String mensagemRequisicao;
	protected String mensagemResposta;
	protected String tipoRequisicao;
	protected String diretorioRemotoCliente;
	protected String[] dadosMensagem;
	
	public RequisicaoGenerica() {
		this.mensagemRequisicao = "";
		this.mensagemResposta = ";";
		this.status = "";
	}
	public RequisicaoGenerica(String status, String mensagemRequisicao, String mensagemResposta) {
		super();
		this.status = status;
		this.mensagemRequisicao = mensagemRequisicao;
		this.mensagemResposta = mensagemResposta;
	}
	public RequisicaoGenerica(String status, String mensagemRequisicao) {
		super();
		this.status = status;
		this.mensagemRequisicao = mensagemRequisicao;
	}	
	
	public void entenderMensagemRequisicao() {
		dadosMensagem = mensagemRequisicao.split("\n");
		tipoRequisicao = dadosMensagem[0];
		diretorioRemotoCliente = dadosMensagem[1];		
	}
}
