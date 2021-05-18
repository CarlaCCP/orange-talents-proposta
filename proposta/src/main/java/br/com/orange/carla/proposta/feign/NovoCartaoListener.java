package br.com.orange.carla.proposta.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;
import feign.FeignException;

@Component
public class NovoCartaoListener {
	

	@Autowired
	private PostaCartao postaCartao;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private novaPropostaRepository repository;
	
	@EventListener
	@Async
	public void escuta (NovoCartaoEvent event) {
		
		try {
			NovaPropostaModel proposta = event.getProposta();
			Cartao cartao = new Cartao(); 
//			cartao.setProposta(proposta.getId());
			CartaoResponse buscaCartao = postaCartao.buscaCartao(proposta.getId()); //numero da proposta
			System.out.println(buscaCartao);
			proposta.setCartao(buscaCartao.getId());
			cartao.setNumero(buscaCartao.getId());
			cartao.setTitular(buscaCartao.getTitular());
			cartao.setEmitidoEm(buscaCartao.getEmitidoEm());
			cartao.setIdProposta(proposta.getId());
			//cartao.getBloqueio().setId(buscaCartao.getBloqueio().getId());
			//cartao.getBloqueio().setBloqueadoEm(buscaCartao.getBloqueio().getBloqueadoEm());
			
			cartaoRepository.save(cartao);
			repository.save(proposta);
		} catch(FeignException e) {
			if(e.status() == 422) {
				System.out.print("Sem cartão");
			}
		}
	
	}
}

