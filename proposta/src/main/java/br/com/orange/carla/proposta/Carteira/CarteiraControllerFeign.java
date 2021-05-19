package br.com.orange.carla.proposta.Carteira;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "carteira", url = "http://localhost:8888")
public interface CarteiraControllerFeign {

	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes/{numeroCartao}/carteiras" , consumes = "application/json")
	public CarteiraResponse associaCarteira(@PathVariable String numeroCartao, @RequestBody CarteiraRequest request);
}
