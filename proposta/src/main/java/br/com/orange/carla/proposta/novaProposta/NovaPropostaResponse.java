package br.com.orange.carla.proposta.novaProposta;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


public class NovaPropostaResponse {


	private String documento; //cpf e cnpj
	
	private String email;

	private String nome;

	private String endereco;

	private BigDecimal salario;
	
	private Status status = Status.ANALISE;
	private String cartao; 

	public NovaPropostaResponse(NovaPropostaModel proposta) {
	
		this.documento = proposta.getDocumento();
		this.email = proposta.getEmail();
		this.nome = proposta.getNome();
		this.endereco = proposta.getEndereco();
		this.salario = proposta.getSalario();
		this.status = proposta.getStatus();
		this.cartao = proposta.getCartao();
		
	}

	public NovaPropostaResponse() {
		
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getCartao() {
		return cartao;
	}
	

	public static List<NovaPropostaResponse> converter (List<NovaPropostaModel> proposta){
		
		return proposta.stream().map(NovaPropostaResponse::new).collect(Collectors.toList());
	}
	
}
