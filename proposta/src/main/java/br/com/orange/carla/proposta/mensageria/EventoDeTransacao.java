package br.com.orange.carla.proposta.mensageria;

import java.math.BigDecimal;

import br.com.orange.carla.proposta.Transacao.CartaoResponseTransacao;
import br.com.orange.carla.proposta.Transacao.Estabelecimento;

public class EventoDeTransacao {

	private String id;

	private BigDecimal valor;

	private CartaoResponseTransacao cartao;
	
	private String efetivadaEm;
	
	private Estabelecimento estabelecimento;

	public EventoDeTransacao(String id, BigDecimal valor, 
			CartaoResponseTransacao cartao, String efetivadaEm, 
			Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.valor = valor;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
		this.estabelecimento = estabelecimento;
	}
	
	

	public EventoDeTransacao() {
		super();
	}



	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	

	public String getEfetivadaEm() {
		return efetivadaEm;
	}



	public CartaoResponseTransacao getCartao() {
		return cartao;
	}



	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}


	

	

	
}
