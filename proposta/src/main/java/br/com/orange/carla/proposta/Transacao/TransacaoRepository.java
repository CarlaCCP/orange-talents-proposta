package br.com.orange.carla.proposta.Transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	

	Boolean existsByCartaoId(String numeroCartao);

	

	Page<Transacao> findAllByCartaoId(String numeroCartao, Pageable paginacao);

}
