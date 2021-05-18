package br.com.orange.carla.proposta.Cartao;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



public class AvisoViagemRequest {

	@NotBlank
	private String destino;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataTermino;
	
	
	public AvisoViagemRequest(@NotBlank String destino, @Future Date dataTermino) {
		super();
		this.destino = destino;
		this.dataTermino = dataTermino;
	}
	public String getDestino() {
		return destino;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	
	public AvisoViagem converter () {
		return new AvisoViagem(destino, dataTermino);
	}
	
}
