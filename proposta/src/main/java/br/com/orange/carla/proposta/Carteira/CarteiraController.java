package br.com.orange.carla.proposta.Carteira;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;
import feign.FeignException;

@RestController
@RequestMapping("/carteira")
public class CarteiraController {

	@Autowired
	private CartaoRepository cartaoRepository;

	@Autowired
	private CarteiraRepository carteiraRepository;

	@Autowired
	private CarteiraControllerFeign carteiraFeign;

	@Autowired
	private novaPropostaRepository propostaRepository;

	@PostMapping("/{numeroCartao}")
	public ResponseEntity<?> associandoCarteira(@PathVariable String numeroCartao,
			@RequestBody @Valid CarteiraRequest request, 
			UriComponentsBuilder uriBuilder) {

		Boolean procuraEmailCartao = propostaRepository.existsByEmailAndCartao(request.getEmail(), numeroCartao);
		Optional<Cartao> possivelCartao = cartaoRepository.findByNumero(numeroCartao);

		if (possivelCartao.isEmpty() || procuraEmailCartao == false) {
			return ResponseEntity.notFound().build();
		} else {
			Cartao cartao = possivelCartao.get();
			Carteira carteira = new Carteira();

			try {
				
				carteiraFeign.associaCarteira(numeroCartao, request);

			} catch (FeignException e) {
				if (e.status() == 422) {
					return ResponseEntity.unprocessableEntity().build();
				}
				
				if(e.status() == 200) {
					carteira.setNumeroCartao(numeroCartao);
					carteira.setStatus(Resultado.ASSOCIADA);
					cartao.setCarteira(carteira);
					carteiraRepository.save(carteira);
					cartaoRepository.save(cartao);
				}

			}
			
			URI uri = uriBuilder.path("/carteira/{numeroCartao}").buildAndExpand(cartao.getNumero()).toUri();
			return ResponseEntity.created(uri).build();
		}
	}
	
	
	
	
	
}
