package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponse;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.TransactionResult;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper {
	
	Transaction toModel(CustomerTransactionRequest customerTransactionRequest);
	
	CustomerTransactionResponse toResponse(TransactionResult transactionResult);
}
