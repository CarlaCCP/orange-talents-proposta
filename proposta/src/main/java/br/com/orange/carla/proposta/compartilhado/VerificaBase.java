package br.com.orange.carla.proposta.compartilhado;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = VerificaBase64.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface VerificaBase {

	String message() default "Valor inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String fieldName();

	Class<?> domainClass();
}
