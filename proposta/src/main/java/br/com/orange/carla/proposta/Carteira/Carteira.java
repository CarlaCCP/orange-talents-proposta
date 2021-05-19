package br.com.orange.carla.proposta.Carteira;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Carteira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	
	@NotBlank
	private String numeroCartao;
	
	
	@Enumerated(EnumType.STRING)
	private Resultado status;
	
	
	public Carteira () {}

	public Carteira(@NotBlank String numeroCartao, Resultado status) {
		super();
		this.numeroCartao = numeroCartao;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public Resultado getStatus() {
		return status;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setStatus(Resultado status) {
		this.status = status;
	}

	
	
	
	
}
