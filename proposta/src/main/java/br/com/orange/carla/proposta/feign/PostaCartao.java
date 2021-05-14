package br.com.orange.carla.proposta.feign;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.orange.carla.proposta.novaProposta.NovaPropostaModel;

@FeignClient(name = "postaCartao", url = "http://localhost:8888/api/cartoes")
public interface PostaCartao {


//	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes")
//	public void solicitacaoAnalise(CartaoRequestFeign request);

	@RequestMapping(method = RequestMethod.GET, consumes = "application/json")
	public CartaoResponse buscaCartao(@RequestParam Long idProposta);
	
//	@RequestMapping(method = RequestMethod.GET, value = "/api/cartoes/{numeroCartao}", consumes = "application/json")
//	public CartaoResponseID persisteCartao(@PathVariable String numeroCartao );

}
