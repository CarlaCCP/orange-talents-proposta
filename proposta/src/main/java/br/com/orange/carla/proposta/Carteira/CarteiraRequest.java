package br.com.orange.carla.proposta.Carteira;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarteiraRequest {


	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private String carteira;

	public String getEmail() {
		return email;
	}

	public String getCarteira() {
		return carteira;
	}

	public CarteiraRequest(@NotBlank @Email String email, @NotNull String carteira) {
		super();
		this.email = email;
		this.carteira = carteira;
	}
	
	
	
	
}
