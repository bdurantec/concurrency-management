package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public class CustomerNotFoundException extends RuntimeException {
	
	private final String message = "Customer Not Found";
	private final HttpStatusCode httpStatusCode = HttpStatus.NOT_FOUND;
}
