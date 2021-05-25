package br.com.orange.carla.proposta.Transacao;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;

public class TransacaoResponse {

	
	private String idTransacao;
	
	
	private BigDecimal valor;
	
	
	private CartaoResponseTransacao cartao;
	
	private Estabelecimento estabelecimento;
	
	private String efetivadaEm;
	
	public TransacaoResponse (Transacao transacao) {
		this.idTransacao = transacao.getIdTransacao();
		this.valor = transacao.getValor();
		this.cartao = transacao.getCartao();
		this.estabelecimento = transacao.getEstabelecimento();
		this.efetivadaEm = transacao.getEfetivadaEm();
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
	
	public static Page<TransacaoResponse> converter(Page<Transacao> transacoes){
		return transacoes.map(TransacaoResponse:: new);
	}
	
}
