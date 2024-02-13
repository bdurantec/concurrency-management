package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class CustomerNotFoundException extends ResponseStatusException {
	
	private static final String message = "Customer Not Found";
	private static final HttpStatusCode httpStatusCode = HttpStatus.NOT_FOUND;
	
	public CustomerNotFoundException() {
		super(httpStatusCode, message);
	}
}
