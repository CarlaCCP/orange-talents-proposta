package br.com.orange.carla.proposta.feign;

import org.springframework.context.ApplicationEvent;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;

public class NovoCartaoEvent  {

	private NovaPropostaModel proposta;


	public NovoCartaoEvent(NovaPropostaModel proposta) {
		super();
		this.proposta = proposta;
	}

	public NovaPropostaModel getProposta() {
		return proposta;
	}
	
	
	
}
