package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class InconsistentBalanceException extends ResponseStatusException {
	
	private static final HttpStatusCode httpStatusCode = HttpStatus.UNPROCESSABLE_ENTITY;
	
	public InconsistentBalanceException(String message) {
		super(httpStatusCode, message);
	}
}
