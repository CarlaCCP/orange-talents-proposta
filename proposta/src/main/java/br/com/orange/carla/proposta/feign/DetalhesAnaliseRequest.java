package br.com.orange.carla.proposta.feign;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;

public class DetalhesAnaliseRequest {

	private String documento;
	private String nome; 
	private String idProposta;
	
	public DetalhesAnaliseRequest (NovaPropostaModel proposta) {
		this.documento = proposta.getDocumento();
		this.nome = proposta.getNome();
		this.idProposta = proposta.getIdProposta();
		
	}
	

	public DetalhesAnaliseRequest () {
	}

	public String getDocumento() {
		return documento;
	}


	public String getNome() {
		return nome;
	}

	public String getIdProposta() {
		return idProposta;
	}


	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}
	
	
	
	
}
