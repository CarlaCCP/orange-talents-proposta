package br.com.orange.carla.proposta.feign;

public class CartaoResponse {

	private String id; //numero cartao
	private String emitidoEm;
	private String titular;
	private String idProposta;
	private BloqueioResponse bloqueio;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public BloqueioResponse getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(BloqueioResponse bloqueio) {
		this.bloqueio = bloqueio;
	}

	public void setEmitidoEm(String emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

	
	
	
}
