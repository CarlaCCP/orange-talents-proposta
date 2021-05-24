package br.com.orange.carla.proposta.Transacao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient(name = "transacao", url = "http://localhost:7777/api/cartoes")
public interface FeignTransacao {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public void iniciaTransacao(@RequestBody TransacaoFeignRequest request);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{numeroCartao}")
	public void terminaTransacao(@PathVariable String numeroCartao);
}
