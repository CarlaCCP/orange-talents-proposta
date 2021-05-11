package br.com.orange.carla.proposta.novaProposta;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import feign.FeignException;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

	@Autowired
	private novaPropostaRepository repository;

	@Autowired
	private AnaliseProposta analise;

	@PostMapping
	public ResponseEntity<NovaPropostaResponse> cadastrar(@RequestBody @Valid NovaPropostaRequest request,
			UriComponentsBuilder uriBuilder) {
		NovaPropostaModel novaProposta = request.converter();
		DetalhesAnaliseRequest retornaAnalise = new DetalhesAnaliseRequest(novaProposta);
		if (repository.findByDocumento(novaProposta.getDocumento()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
		} else {
			// Irá capturar a restrição através da exception
			try {
				analise.solicitacaoAnalise(retornaAnalise);
			} catch (FeignException e) {
				if (e.status() == 422) {
					novaProposta.setStatus(StatusProposta.NAO_ELEGIVEL);
				}
			}

			if (novaProposta.getStatus() == null) {
				novaProposta.setStatus(StatusProposta.ELEGIVEL);
			}
			repository.save(novaProposta);
			URI uri = uriBuilder.path("/novaProposta/{id}").buildAndExpand(novaProposta.getIdProposta()).toUri();
			return ResponseEntity.created(uri).body(new NovaPropostaResponse(novaProposta));
		}
	}

	@GetMapping
	public List<NovaPropostaResponse> buscaTodos() {
		List<NovaPropostaModel> proposta = repository.findAll();

		return NovaPropostaResponse.converter(proposta);
	}

	public void setaAnalise() {

	}
}
