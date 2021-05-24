package br.com.orange.carla.proposta.Transacao;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartaoResponseTransacao {
	
	
	private String id;
	private String email;
	
	
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	
	
	
}
