package br.com.orange.carla.proposta.compartilhado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;



@RestControllerAdvice
public class ErrorHandler {

	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDTO> handler (MethodArgumentNotValidException exception){
		
		List<ErroFormularioDTO> dto = new ArrayList<>();
		List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
		
		
		fieldError.forEach(e ->{
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormularioDTO erro = new ErroFormularioDTO(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
 	}
	

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ErroPadronizado> handleResponseStatusException(ResponseStatusException responseStatusException) {
	    Collection<String> mensagens = new ArrayList<>();
	    mensagens.add(responseStatusException.getReason());

	    ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
	    return ResponseEntity.status(responseStatusException.getStatus()).body(erroPadronizado);
	}
	
}
