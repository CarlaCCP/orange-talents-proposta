package br.com.orange.carla.proposta.Transacao;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import br.com.orange.carla.proposta.mensageria.EventoDeTransacao;

public class TransacaoModelRequest {

	
	private String idTransacao;
	
	@NotNull
	private BigDecimal valor;
	
	private String efetivadaEm;
	
	private CartaoResponseTransacao cartao;
	
	private Estabelecimento estabelecimento;
	

	

	public TransacaoModelRequest(EventoDeTransacao transacao) {
		this.idTransacao = transacao.getId();
		this.valor = transacao.getValor();
		this.efetivadaEm = transacao.getEfetivadaEm();
		this.estabelecimento = transacao.getEstabelecimento();
		this.cartao = transacao.getCartao();
	}



	public String getIdTransacao() {
		return idTransacao;
	}



	public void setIdTransacao(String idTransacao) {
		this.idTransacao = idTransacao;
	}



	public BigDecimal getValor() {
		return valor;
	}



	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}



	public String getEfetivadaEm() {
		return efetivadaEm;
	}



	public void setEfetivadaEm(String efetivadaEm) {
		this.efetivadaEm = efetivadaEm;
	}


	


	public CartaoResponseTransacao getCartao() {
		return cartao;
	}



	public void setCartao(CartaoResponseTransacao cartao) {
		this.cartao = cartao;
	}



	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}



	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}



	public Transacao converter() {
		return new Transacao(idTransacao, valor, cartao, estabelecimento, efetivadaEm);
	}
	
}
