package br.com.orange.carla.proposta.Biometria;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaResponse;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

	@Autowired
	private BiometriaRepository biometriaRepository;

	@Autowired
	private CartaoRepository cartaoRepository;

	@PostMapping("/{numero}")
	public ResponseEntity<BiometriaResponse> cadastrar(@PathVariable String numero, @RequestBody @Valid BiometriaRequest request,
			UriComponentsBuilder uriBuilder) {
		try {
			Biometria biometria = request.converter(cartaoRepository, numero);

			URI uri = uriBuilder
					.path("/biometria/{numero}")
					.buildAndExpand(biometria.getCartao().getNumero())
					.toUri();
			
			if (cartaoRepository.existsByNumero(numero)) {
				biometriaRepository.save(biometria);
				return ResponseEntity.created(uri).body(new BiometriaResponse(biometria));
			}
		} catch (Exception e) {

		}
		return ResponseEntity.notFound().build();

	}

	@GetMapping
	public List<BiometriaResponse> buscaTodos() {
		List<Biometria> biometria = biometriaRepository.findAll();
		System.out.println(biometria);
		return BiometriaResponse.converter(biometria);
	}

}
