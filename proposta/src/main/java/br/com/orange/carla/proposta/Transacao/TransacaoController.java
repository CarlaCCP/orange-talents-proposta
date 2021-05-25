package br.com.orange.carla.proposta.Transacao;

import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.orange.carla.proposta.Cartao.CartaoRepository;
import br.com.orange.carla.proposta.novaProposta.novaPropostaRepository;
import feign.FeignException;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	@Autowired
	private novaPropostaRepository propostaRepository;
	
	@Autowired
	private FeignTransacao feignTransacao;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@PostMapping
	public ResponseEntity<?> comecaTransacao (@RequestBody @Valid TransacaoFeignRequest request
			){
		Boolean procuraEmailCartao = propostaRepository.existsNovaPropostaModelByEmailAndCartao(request.getEmail(), request.getId());
		
		if (procuraEmailCartao == false) {
			return ResponseEntity.notFound().build();
		}
		else {
			try {
				feignTransacao.iniciaTransacao(request);
			} catch (FeignException e) {
				if (e.status() == 422) {
					return ResponseEntity.unprocessableEntity().build();
				}
			}
			
		}
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/{numeroCartao}")
	public ResponseEntity<?> paraTransacao (@PathVariable String numeroCartao){
		if(cartaoRepository.findByNumero(numeroCartao).isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			
			feignTransacao.terminaTransacao(numeroCartao);
			return ResponseEntity.ok().build();
		}
		
	}
	
	@GetMapping("/todos/{numeroCartao}")
	public Page<TransacaoResponse> buscaTodos (@PathVariable String numeroCartao,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao){
		Boolean numero = transacaoRepository.existsByCartaoId(numeroCartao);
		if (numero == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado");
		}
		else {
			Page<Transacao> transacoes = transacaoRepository.findAllByCartaoId(numeroCartao, paginacao);
			return TransacaoResponse.converter(transacoes);
		}
		
	}
	
}
