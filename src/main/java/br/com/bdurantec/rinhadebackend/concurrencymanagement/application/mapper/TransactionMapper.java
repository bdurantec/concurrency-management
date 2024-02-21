package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper
public interface TransactionMapper {

  Transaction toModel(CustomerTransactionRequest customerTransactionRequest);

  CustomerTransactionResponseDTO toResponse(Customer customer);
}
