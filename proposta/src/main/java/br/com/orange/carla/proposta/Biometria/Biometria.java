package br.com.orange.carla.proposta.Biometria;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.compartilhado.VerificaBase;

@Entity
public class Biometria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //chave primaria
	
	private String fingerprint; //irá fazer uma validacao para sabe se é base64
	
	private LocalDateTime dataEmissao= LocalDateTime.now();
	
	@ManyToOne
	private Cartao cartao; //fazer o reponse para associar o numero do cartao

	public Biometria(String fingerprint, Cartao cartao) {
		super();
		this.fingerprint = fingerprint;
		this.cartao = cartao;
	}
	
	
	public Biometria() {
		super();
	}


	public Long getId() {
		return id;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}
 
}
