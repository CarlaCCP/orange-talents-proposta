package br.com.orange.carla.proposta.Cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.orange.carla.proposta.feign.CartaoRequestFeign;
import br.com.orange.carla.proposta.feign.PostaCartao;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.Status;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;

@Component
public class CartaoController {

	@Autowired
	private CartaoRepository repository;
	
	@Autowired
	private novaPropostaRepository propostaRepository;
	
	@Autowired
	private PostaCartao postaCartao;
	

	//consultar se existe um cartao para determinada proposta, que não tem numero de cartao
	//@Scheduled(fixedDelay = 1000)
	
}
