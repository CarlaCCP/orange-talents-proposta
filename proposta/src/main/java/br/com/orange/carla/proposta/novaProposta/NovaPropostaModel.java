package br.com.orange.carla.proposta.novaProposta;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.orange.carla.proposta.Cartao.Cartao;



@Entity
@Table(name = "nova_proposta")
public class NovaPropostaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String idProposta;
	@NotEmpty
	private String documento; //cpf e cnpj
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String endereco; //endereçoRequest como objeto e valida os dados com anotação @Embedded @EmBEDABLE
	@NotNull @Positive
	private BigDecimal salario;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ANALISE;

	private String cartao; 
	public NovaPropostaModel() {
		// TODO Auto-generated constructor stub
	}

	public NovaPropostaModel( @NotEmpty String documento, @Email @NotEmpty String email,
			@NotEmpty String nome, @NotEmpty String endereco, @NotNull @Positive BigDecimal salario,  Status status, String cartao ) {
		super();
		
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
		this.status = status;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
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

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public void setIdProposta(String idProposta) {
		this.idProposta = idProposta;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
	
}
