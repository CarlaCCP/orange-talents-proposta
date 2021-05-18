package br.com.orange.carla.proposta.Cartao;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AvisoViagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String destino;
	private LocalDateTime instanteSolicitacao = LocalDateTime.now();
	@Future
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dataTermino;
	
	@Enumerated(EnumType.STRING)
	private StatusViagem statusViagem;
	
	private String userAgent;
	private String host;
	
	public AvisoViagem () {}
	
	public AvisoViagem(String destino, @Future Date dataTermino) {
		super();
		this.destino = destino;
		this.dataTermino = dataTermino;
	}
	public Long getId() {
		return id;
	}
	public String getDestino() {
		return destino;
	}
	public LocalDateTime getInstanteSolicitacao() {
		return instanteSolicitacao;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public StatusViagem getStatusViagem() {
		return statusViagem;
	}
	public void setStatusViagem(StatusViagem statusViagem) {
		this.statusViagem = statusViagem;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}
