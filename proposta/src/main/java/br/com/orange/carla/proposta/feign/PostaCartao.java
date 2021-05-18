package br.com.orange.carla.proposta.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.orange.carla.proposta.Cartao.AvisoViagemRequest;
import br.com.orange.carla.proposta.Cartao.Cartao;
import br.com.orange.carla.proposta.Cartao.CartaoResponseModel;
import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;

@FeignClient(name = "postaCartao", url = "http://localhost:8888")
public interface PostaCartao {


//	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes")
//	public void solicitacaoAnalise(CartaoRequestFeign request);

	@RequestMapping(method = RequestMethod.GET, value = "/api/cartoes" , consumes = "application/json")
	public CartaoResponse buscaCartao(@RequestParam Long idProposta);
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/cartoes" , consumes = "application/json")
	public CartaoResponseModel buscaCartaoBloqueado(@RequestParam Long idProposta);
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes/{numeroCartao}/bloqueios", consumes = "application/json")
	public Cartao solicitaBloqueio(@PathVariable String numeroCartao, @RequestBody TesteRequest teste);

	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes/{numeroCartao}/avisos", consumes = "application/json")
	public Cartao solicitaAvisoViagem(@PathVariable String numeroCartao, @RequestBody AvisoViagemRequest request);
}
