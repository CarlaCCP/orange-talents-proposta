package br.com.orange.carla.proposta.Transacao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.orange.carla.proposta.Cartao.Cartao;

@Entity
public class Transacao {

	@Id
	private String idTransacao;
	
	@NotNull
	private BigDecimal valor;
	
	
	// tentar fazer um relacionamento com cartao
	//cartao sobe vazio, pois existe dois "id" na classe
	@Embedded
	private CartaoResponseTransacao cartao;
	@Embedded
	private Estabelecimento estabelecimento;
	
	private String efetivadaEm;
	
	

	public Transacao() {
		super();
	}

	public Transacao(String id, @NotNull BigDecimal valor, CartaoResponseTransacao cartao,
			Estabelecimento estabelecimento, String efetivadaEm) {
		super();
		this.idTransacao = id;
		this.valor = valor;
		this.cartao = cartao;
		this.estabelecimento = estabelecimento;
		this.efetivadaEm = efetivadaEm;
	}

	public String getIdTransacao() {
		return idTransacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public CartaoResponseTransacao getCartao() {
		return cartao;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public String getEfetivadaEm() {
		return efetivadaEm;
	}

	

	
}
