package br.com.orange.carla.proposta.novaProposta;

public class DetalhesAnaliseResponse {

	private String documento;
	private String nome; 
	private Long idProposta;
	private ResultadoSolicitacao resultado;
	

	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public Long getIdProposta() {
		return idProposta;
	}
	public ResultadoSolicitacao getResultado() {
		return resultado;
	}
	
	
}
