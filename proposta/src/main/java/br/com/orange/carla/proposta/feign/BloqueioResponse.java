package br.com.orange.carla.proposta.feign;

public class BloqueioResponse {

	private String id; 
	private String bloqueadoEm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBloqueadoEm() {
		return bloqueadoEm;
	}
	public void setBloqueadoEm(String bloqueadoEm) {
		this.bloqueadoEm = bloqueadoEm;
	}
	
	
}
