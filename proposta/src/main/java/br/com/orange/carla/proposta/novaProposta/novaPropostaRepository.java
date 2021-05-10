package br.com.orange.carla.proposta.novaProposta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface novaPropostaRepository extends JpaRepository<NovaPropostaModel, Long> {

	Optional<NovaPropostaModel> findByDocumento(String documento);

}
