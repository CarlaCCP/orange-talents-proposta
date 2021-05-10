package br.com.orange.carla.proposta.novaProposta;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	private StatusProposta status = StatusProposta.ANALISE;
	
	
	public NovaPropostaRequest(@NotEmpty @Documento String documento, @Email @NotEmpty String email,
			@NotEmpty String nome, @NotEmpty String endereco, @NotNull @Positive BigDecimal salario, StatusProposta status) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
	}
	
	public NovaPropostaModel converter () {
		return new NovaPropostaModel(documento, email, nome, endereco, salario, status);
	}

	public String getDocumento() {
		return documento;
	}

	public StatusProposta getStatus() {
		return status;
	}

	public void setStatus(StatusProposta status) {
		this.status = status;
	}
	
	
	
}
