package br.com.orange.carla.proposta.Cartao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bloqueio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private LocalDateTime bloqueadoEm = LocalDateTime.now();;
	private String userAgent;
	private String host;
	
	
	public Bloqueio () {}
	public Bloqueio(String userAgent, String host) {
		super();
		this.userAgent = userAgent;
		this.host = host;
	}
	public Long getId() {
		return id;
	}
	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}
	public String getUserAgent() {
		return userAgent;
	}
	public String getHost() {
		return host;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setBloqueadoEm(LocalDateTime bloqueadoEm) {
		this.bloqueadoEm = bloqueadoEm;
	}
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	

	
}
