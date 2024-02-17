package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.controller;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerStatementResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.StatementMapper;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.StatementMapperImpl;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.TransactionMapper;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper.TransactionMapperImpl;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.StatementService;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clientes")
public class CustomerController {

  private final TransactionService transactionService;
  private final StatementService statementService;
  private final TransactionMapper transactionMapper;
  private final StatementMapper statementMapper;

  public CustomerController(
      TransactionService transactionService,
      StatementService statementService
  ) {
    this.transactionService = transactionService;
    this.transactionMapper = new TransactionMapperImpl();
    this.statementService = statementService;
    this.statementMapper = new StatementMapperImpl();
  }

  @PostMapping("/{id}/transacoes")
  public ResponseEntity<CustomerTransactionResponseDTO> postTransactions(
      @PathVariable("id") Integer customerId,
      @Valid @RequestBody CustomerTransactionRequest request
  ) {
    var transactionResult = transactionService.doTransaction(customerId, transactionMapper.toModel(request));
    return ResponseEntity.ok(transactionMapper.toResponse(transactionResult));
  }

  @GetMapping("/{id}/extrato")
  public ResponseEntity<CustomerStatementResponseDTO> getStatement(
      @PathVariable("id") Integer customerId
  ) {
    var statement = statementService.getStatement(customerId);
    return ResponseEntity.ok(statementMapper.toResponse(statement));
  }
}