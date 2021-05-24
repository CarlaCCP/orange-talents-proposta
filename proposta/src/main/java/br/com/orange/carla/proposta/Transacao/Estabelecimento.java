package br.com.orange.carla.proposta.Transacao;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

	private String nome;
	private String cidade;
	private String endereco;
	
	
	public String getNome() {
		return nome;
	}
	public String getCidade() {
		return cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	
	
	
	
}
