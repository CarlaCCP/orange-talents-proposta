package br.com.orange.carla.proposta.Cartao;

import java.util.List;
import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.orange.carla.proposta.Biometria.Biometria;

@Entity
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCartao; 
	private String numero;
	private String emitidoEm;
	private String titular;
	private Long idProposta;
	
	@OneToOne
	private Bloqueio bloqueio;
	
	@Enumerated(EnumType.STRING)
	private CartaoStatus statusCartao; 
	
	@OneToMany
	private List<Biometria> biometria;
	
	public Cartao() {
		
	}
	
	public Cartao(String numero,String emitidoEm, String titular, Long idProposta ) {
		super();
		this.numero = numero;
		this.emitidoEm = emitidoEm;
		this.titular = titular;
		this.idProposta = idProposta;
		//this.biometria = biometria;
	}
	public Long getIdCartao() {
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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


	public List<Biometria> getBiometria() {
		return biometria;
	}

	public void setBiometria(List<Biometria> biometria) {
		this.biometria = biometria;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public Bloqueio getBloqueio() {
		return bloqueio;
	}

	public void setBloqueio(Bloqueio bloqueio) {
		this.bloqueio = bloqueio;
	}

	public void setStatusCartao(CartaoStatus statusCartao) {
		this.statusCartao = statusCartao;
	}
	
	
}
