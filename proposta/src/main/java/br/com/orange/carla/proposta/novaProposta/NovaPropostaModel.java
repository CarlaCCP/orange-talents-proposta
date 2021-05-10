package br.com.orange.carla.proposta.novaProposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;



@Entity
@Table(name = "nova_proposta")
public class NovaPropostaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProposta;
	@NotEmpty
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
	public NovaPropostaModel() {
		// TODO Auto-generated constructor stub
	}

	public NovaPropostaModel( @NotEmpty String documento, @Email @NotEmpty String email,
			@NotEmpty String nome, @NotEmpty String endereco, @NotNull @Positive BigDecimal salario,  StatusProposta status ) {
		super();
		
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
	}

	public Long getIdProposta() {
		return idProposta;
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
	
	

	public StatusProposta getStatus() {
		return status;
	}

	public void setStatus(StatusProposta status) {
		this.status = status;
	}
	
	
}
