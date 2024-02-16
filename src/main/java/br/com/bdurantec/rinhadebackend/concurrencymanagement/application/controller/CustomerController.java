package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.controller;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponse;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.TransactionMapper;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.TransactionMapperImpl;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clientes")
public class CustomerController {
	
	private final TransactionService transactionService;
	private final TransactionMapper mapper;
	
	public CustomerController(
			TransactionService transactionService
	) {
		this.transactionService = transactionService;
		this.mapper = new TransactionMapperImpl();
	}
	
	@PostMapping("/{id}/transacoes")
	public ResponseEntity<CustomerTransactionResponse> postTransactions(
			@PathVariable("id") Integer customerId,
			@Valid @RequestBody CustomerTransactionRequest request
	) {
		var transactionResult = transactionService.performsTransaction(customerId, mapper.toModel(request));
		return ResponseEntity.ok(mapper.toResponse(transactionResult));
	}
}