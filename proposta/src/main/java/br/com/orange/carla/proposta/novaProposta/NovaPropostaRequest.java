package br.com.orange.carla.proposta.novaProposta;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.compartilhado.Documento;
import br.com.orange.carla.proposta.compartilhado.UniqueValue;

public class NovaPropostaRequest {

	
	@NotEmpty
	@Documento
	//@UniqueValue(domainClass = NovaPropostaModel.class, fieldName = "documento")
	private String documento; //cpf e cnpj
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco;
	@NotNull @Positive
	private BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ANALISE;
	
	private String cartao;
	public NovaPropostaRequest(@NotEmpty @Documento String documento, @Email @NotEmpty String email,
			@NotEmpty String nome, @NotEmpty String endereco, @NotNull @Positive BigDecimal salario, Status status, String cartao) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
		this.cartao = cartao;
	}
	
	public NovaPropostaModel converter () {
	
		
		return new NovaPropostaModel(documento, email, nome, endereco, salario, status, cartao);
	}

	public String getDocumento() {
		return documento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getcartao() {
		return cartao;
	}
	
	
}
