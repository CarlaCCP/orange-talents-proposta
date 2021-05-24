package br.com.orange.carla.proposta.mensageria;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.Transacao.Transacao;
import br.com.orange.carla.proposta.Transacao.TransacaoModelRequest;
import br.com.orange.carla.proposta.Transacao.TransacaoRepository;

@Component
public class ListenerDeTransacao {
	
	@Autowired
	private TransacaoRepository repository;

	@Autowired
	private CartaoRepository cartaoRepository;
	
	@KafkaListener(topics = "transacoes")
	public void ouvir(EventoDeTransacao eventoDeTransacao) {
		if (eventoDeTransacao.getId() == null || eventoDeTransacao.getValor() == null 
				|| eventoDeTransacao.getCartao().getId() == null) {
		
		}
		else {
			TransacaoModelRequest request = new TransacaoModelRequest(eventoDeTransacao);
			Transacao transacao = request.converter(); //fazer a associação de ID dentro do metodo converter
//			Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(eventoDeTransacao.getCartao().getId());
//			Cartao cartao = possivelCartao.get();
			repository.save(transacao);
		}
		
	}
}
