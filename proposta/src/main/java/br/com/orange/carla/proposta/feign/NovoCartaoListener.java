package br.com.orange.carla.proposta.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;
import feign.FeignException;

@Component
public class NovoCartaoListener {
	

	@Autowired
	private PostaCartao postaCartao;
	
	@Autowired
	private novaPropostaRepository repository;
	
	@EventListener
	@Async
	public void escuta (NovoCartaoEvent event) {
		
		try {
			
			NovaPropostaModel proposta = event.getProposta();
			CartaoResponse buscaCartao = postaCartao.buscaCartao(proposta.getId());
			System.out.println(buscaCartao);
			proposta.setCartao(buscaCartao.getId());
			repository.save(proposta);
		} catch(FeignException e) {
			if(e.status() == 422) {
				System.out.print("Sem cartão");
			}
		}
	
	}
}

