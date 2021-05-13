package br.com.orange.carla.proposta.Cartao;

public class CartaoRequest {

	private String numeroCartao;
	private String emitidoEm;
	private String titular;
	private Long idProposta;

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getEmitidoEm() {
		return emitidoEm;
	}

	public void setEmitidoEm(String emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
	
	public Cartao converter () {
		return new Cartao(numeroCartao,emitidoEm, titular, idProposta);
	}
}
