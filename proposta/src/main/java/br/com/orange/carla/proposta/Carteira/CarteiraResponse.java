package br.com.orange.carla.proposta.Carteira;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CarteiraResponse {

	@Enumerated(EnumType.STRING)
	private Resultado status;
	
	private String numeroCartao;
	
	public CarteiraResponse(Carteira carteira) {
		this.status = carteira.getStatus();
		this.numeroCartao = carteira.getNumeroCartao();
	}
	

	public Resultado getStatus() {
		return status;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}


	public void setStatus(Resultado status) {
		this.status = status;
	}


	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	
	
	
}
