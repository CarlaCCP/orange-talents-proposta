package br.com.orange.carla.proposta.novaProposta;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/novaProposta")
public class NovaPropostaController {

	@Autowired
	private novaPropostaRepository repository;

	@PostMapping
	public ResponseEntity<NovaPropostaResponse> cadastrar(@RequestBody @Valid NovaPropostaRequest request,
			UriComponentsBuilder uriBuilder) {
		NovaPropostaModel novaProposta = request.converter();
		repository.findByDocumento(novaProposta.getDocumento());
		if ( repository.findByDocumento(novaProposta.getDocumento()).isPresent()) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Documento já cadastrado");
					
		} else {
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
}
