package br.com.orange.carla.proposta.Biometria;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BiometriaResponse {

	
	private String fingerprint;
	private String numero; 
	
	
	public BiometriaResponse(Biometria biometria) {
		this.fingerprint = biometria.getFingerprint();
		this.numero = biometria.getCartao().getNumero();
	}


	public String getFingerprint() {
		return fingerprint;
	}


	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}


	public String getNumeroCartao() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public static List<BiometriaResponse> converter(List<Biometria> biometria) {
		
		return biometria.stream().map(BiometriaResponse::new).collect(Collectors.toList());
	}
	
	
}
