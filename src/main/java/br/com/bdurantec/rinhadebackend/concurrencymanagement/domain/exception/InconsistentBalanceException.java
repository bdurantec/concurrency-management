package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class InconsistentBalanceException extends RuntimeException {
	
	private final String message;
	private final HttpStatusCode httpStatusCode = HttpStatus.UNPROCESSABLE_ENTITY;
	
	public InconsistentBalanceException(String message) {
		this.message = message;
	}
}
