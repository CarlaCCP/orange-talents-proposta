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
	private String emitidoEm;
	private String titular;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private NovaPropostaModel proposta;
	
	
	public Cartao(Long idCartao, String emitidoEm, String titular, NovaPropostaModel proposta) {
		super();
		this.idCartao = idCartao;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.proposta = proposta;
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
	public NovaPropostaModel getProposta() {
		return proposta;
	}
	
}
