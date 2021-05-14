package br.com.orange.carla.proposta.Biometria;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.compartilhado.VerificaBase;

public class BiometriaRequest {

	@NotBlank
	@VerificaBase(domainClass = Biometria.class, fieldName = "fingerprint")
	private String fingerprint;
	

	public Biometria converter(CartaoRepository repository, String id) {
		
		Optional<Cartao> possivelCartao = repository.findByNumero(id);
		Cartao cartao = possivelCartao.get();
		return new Biometria(fingerprint, cartao);

	}


	
//	public BiometriaRequest(@NotBlank String fingerprint) {
//		super();
//		this.fingerprint = fingerprint;
//	}



	public String getFingerprint() {
		return fingerprint;
	}

}
