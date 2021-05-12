package br.com.orange.carla.proposta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "analiseProsta", url = "http://localhost:9999")
public interface AnaliseProposta {

	@RequestMapping(method = RequestMethod.POST, value = "/api/solicitacao")
	public void solicitacaoAnalise (DetalhesAnaliseRequest request);
}
