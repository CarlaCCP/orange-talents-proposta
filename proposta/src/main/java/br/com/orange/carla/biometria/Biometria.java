package br.com.orange.carla.biometria;

import br.com.orange.carla.proposta.Cartao.Cartao;

public class Biometria {

	private Long id; //chave primaria 
	private String fingerprint; //irá fazer uma validacao para sabe se é base64
	private Cartao cartao; //fazer o reponse para associar o numero do cartao
}
