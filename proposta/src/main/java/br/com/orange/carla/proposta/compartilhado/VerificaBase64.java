package br.com.orange.carla.proposta.compartilhado;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



import br.com.orange.carla.proposta.Biometria.Biometria;

public class VerificaBase64 implements ConstraintValidator<VerificaBase, Object> {

	private String domainAttribute;
	private Class<?> klass;

	public void initialize(VerificaBase params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean encontraBase = false;
		
		String pattern = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(value.toString());
		if (m.find()) {
			encontraBase = true;
		}

		return encontraBase;

//		boolean verificaBase = Base64.isBase64(value.toString());
//		System.out.println(verificaBase + value.toString());
//		return Base64.isBase64(value.toString());
	}


//	@Override
//	public boolean isValid(Object value, ConstraintValidatorContext context) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
