package br.com.orange.carla.proposta.Cartao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

	Optional<Cartao> findByNumero(String numero);

	boolean existsByNumero(String numero);

}
