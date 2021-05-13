package br.com.orange.carla.proposta.Cartao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCartao;
	private String numeroCartao;
	private String emitidoEm;
	private String titular;
	
	private Long idProposta;
	
	public Cartao() {
		
	}
	
	public Cartao(String numeroCartao,String emitidoEm, String titular, Long idProposta) {
		super();
		this.numeroCartao = numeroCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.idProposta = idProposta;
	}
	public Long getId() {
		return idCartao;
	}
	public String getEmitidoEm() {
		return emitidoEm;
	}
	public String getTitular() {
		return titular;
	}
	public Long getIdProposta() {
		return idProposta;
	}

	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setEmitidoEm(String emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
	
	
}
