package br.com.orange.carla.proposta.Cartao;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.carla.proposta.feign.CartaoRequestFeign;
import br.com.orange.carla.proposta.feign.CartaoResponse;
import br.com.orange.carla.proposta.feign.PostaCartao;
import br.com.orange.carla.proposta.feign.TesteRequest;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.Status;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;
import feign.FeignException;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository repository;

	@Autowired
	private novaPropostaRepository propostaRepository;

	@Autowired
	private PostaCartao postaCartao;
	@Autowired
	private BloqueioRepository bloqueioRepository;
	// falta gravar as informações, está bloqueando conforme pedido
	@PostMapping("/{numeroCartao}")
	public ResponseEntity<?> bloqueiaCartao(@PathVariable String numeroCartao, 
			@RequestBody TesteRequest request, 
			@RequestHeader("user-agent") String userAgent,
			@RequestHeader("host") String host,
			UriComponentsBuilder uriBuilder) {

		Optional<Cartao> possivelCartao = repository.findByNumero(numeroCartao);
		if (possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			Cartao cartao = possivelCartao.get();
			try {
				postaCartao.solicitaBloqueio(numeroCartao, request);
				
				Bloqueio novoBloqueio = new Bloqueio ();
				novoBloqueio.setUserAgent(userAgent);
				novoBloqueio.setHost(host);
				bloqueioRepository.save(novoBloqueio);
				cartao.setBloqueio(novoBloqueio);
				repository.save(cartao);
			}catch (FeignException e) {
				if(e.status() == 422) {
					return ResponseEntity.unprocessableEntity().build();
				}
			}

			URI uri = uriBuilder.path("/cartao/{numeroCartao}").buildAndExpand(cartao.getNumero()).toUri();
			return ResponseEntity.created(uri).build();

		}

	}

}
