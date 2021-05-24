package br.com.orange.carla.proposta.Transacao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//Classe para ser usada unicamente no Feign, dados não serão persistidos ainda
public class TransacaoFeignRequest {

	@NotBlank
	private String id;
	
	@Email
	@NotBlank
	private String email;



	public String getEmail() {
		return email;
	}



	public String getId() {
		return id;
	}

	
}
