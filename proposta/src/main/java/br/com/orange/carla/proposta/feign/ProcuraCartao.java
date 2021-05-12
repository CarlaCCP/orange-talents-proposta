package br.com.orange.carla.proposta.feign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.Status;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;

@Component
public class ProcuraCartao {

	@Autowired
	private novaPropostaRepository repository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Scheduled(fixedDelay = 90000)
	public void procuraCartao() {
		List<NovaPropostaModel> propostas = repository.findNovaPropostaModelByStatusAndCartao(Status.ELEGIVEL, null);
		System.out.println(propostas.size());
		for (NovaPropostaModel proposta : propostas) {
			publisher.publishEvent(new NovoCartaoEvent(proposta));
			
		}
	}
		
}
