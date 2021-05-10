package br.com.orange.carla.proposta.novaProposta;

public class DetalhesAnaliseRequest {

	private String documento;
	private String nome; 
	private Long idProposta;
	
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

	public Long getIdProposta() {
		return idProposta;
	}
	
	
	
}
