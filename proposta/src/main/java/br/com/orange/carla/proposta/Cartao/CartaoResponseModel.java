package br.com.orange.carla.proposta.Cartao;

import br.com.orange.carla.proposta.feign.BloqueioResponse;

public class CartaoResponseModel {

	
	private Long idCartao; 
	private String numero;
	private String emitidoEm;
	private String titular;
	private Long idProposta;
	
	
	

//	public CartaoResponseModel(Cartao cartao) {
//		this.idCartao = cartao.getIdCartao();
//		this.titular = cartao.getTitular();
//		this.numero = cartao.getNumero();
//		this.idProposta = cartao.getIdProposta();
//		this.bloqueio = cartao.getBloqueio();
//	}
//	

	public CartaoResponseModel (Cartao cartao) {
		this.titular = cartao.getTitular();
		this.idCartao = cartao.getIdCartao();
		this.numero = cartao.getNumero();
		this.emitidoEm = cartao.getEmitidoEm();
		this.idProposta = cartao.getIdProposta();
		
	}
	
	public CartaoResponseModel() {
		
	}
	
	public Long getIdCartao() {
		return idCartao;
	}

	public String getNumero() {
		return numero;
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


	
	
}
