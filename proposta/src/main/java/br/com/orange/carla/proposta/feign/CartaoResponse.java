package br.com.orange.carla.proposta.feign;

public class CartaoResponse {

	private String id; //numero cartao
	private String emitidoEm;
	private String titular;
	private String idProposta;
	

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
	
	
}
