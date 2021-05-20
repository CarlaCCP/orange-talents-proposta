package br.com.orange.carla.proposta.novaProposta;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.feign.AnaliseProposta;
import br.com.orange.carla.proposta.feign.CartaoRequestFeign;
import br.com.orange.carla.proposta.feign.DetalhesAnaliseRequest;
import br.com.orange.carla.proposta.feign.PostaCartao;
import feign.FeignException;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

	@Autowired
	private novaPropostaRepository repository;

	@Autowired
	private AnaliseProposta analise;

	@PostMapping() //o identificador é passado como path parameter, logica errada
	public ResponseEntity<NovaPropostaResponse> cadastrar(@RequestBody @Valid NovaPropostaRequest request,
			UriComponentsBuilder uriBuilder) {
		NovaPropostaModel novaProposta = request.converter();
		DetalhesAnaliseRequest retornaAnalise = new DetalhesAnaliseRequest(novaProposta);
		
		
		String salt = KeyGenerators.string().generateKey();
		Encryptors.stronger(request.getDocumento(), salt);
		novaProposta.setDocumento(salt);     
		
		
		if (repository.findByDocumento(novaProposta.getDocumento()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
			// ou repository.existsByDocumento(request.getDocumento) menos processamento volta boolean
		} else {
			// Irá capturar a restrição através da exception
			try {
				repository.save(novaProposta);
				retornaAnalise.setIdProposta(novaProposta.getId().toString());
				analise.solicitacaoAnalise(retornaAnalise);
			} catch (FeignException e) {
				if (e.status() == 422) {
					novaProposta.setStatus(Status.NAO_ELEGIVEL);
				}
			}
			if (novaProposta.getStatus() == null) {
				novaProposta.setStatus(Status.ELEGIVEL);
			}
			repository.save(novaProposta);
			URI uri = uriBuilder.path("/novaProposta/{id}").buildAndExpand(novaProposta.getId()).toUri();
			return ResponseEntity.created(uri).body(new NovaPropostaResponse(novaProposta));
		}
	}

	@GetMapping
	public List<NovaPropostaResponse> buscaTodos() {
		List<NovaPropostaModel> proposta = repository.findAll();

		return NovaPropostaResponse.converter(proposta);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NovaPropostaResponse> buscaUm(@PathVariable Long id) {
		Optional<NovaPropostaModel> proposta = repository.findById(id);

		if (proposta.isPresent()) {
			return ResponseEntity.ok(new NovaPropostaResponse(proposta.get()));
		}

		return ResponseEntity.notFound().build();
	}

}
