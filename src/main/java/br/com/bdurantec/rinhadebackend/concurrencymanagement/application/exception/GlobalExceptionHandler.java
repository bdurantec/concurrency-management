package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.exception;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.ErrorResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.CustomerNotFoundException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.InconsistentBalanceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({InconsistentBalanceException.class, CustomerNotFoundException.class})
	public ResponseEntity<ErrorResponseDTO> inconsistentBalanceException(
			ResponseStatusException exception
	) {
		var error = new ErrorResponseDTO(exception.getMessage(), exception.getStatusCode().value());
		return new ResponseEntity<>(error, exception.getStatusCode());
	}
}
