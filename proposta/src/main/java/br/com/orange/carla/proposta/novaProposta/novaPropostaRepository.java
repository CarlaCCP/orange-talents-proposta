package br.com.orange.carla.proposta.novaProposta;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface novaPropostaRepository extends JpaRepository<NovaPropostaModel, Long> {

	Optional<NovaPropostaModel> findByDocumento(String documento);

	Collection<NovaPropostaModel> findByStatus(Status elegivel);

	List<NovaPropostaModel> findNovaPropostaModelByStatusAndCartao(Status elegivel, String cartao);

	

	Boolean existsByEmailAndCartao(String email, String numeroCartao);

	Boolean existsNovaPropostaModelByEmailAndCartao(String email, String numeroCartao);

}
