package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponse;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.TransactionResult;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-12T11:50:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toModel(CustomerTransactionRequest customerTransactionRequest) {
        if ( customerTransactionRequest == null ) {
            return null;
        }

        Long value = null;
        String type = null;
        String description = null;

        value = customerTransactionRequest.value();
        type = customerTransactionRequest.type();
        description = customerTransactionRequest.description();

        Transaction transaction = new Transaction( value, type, description );

        return transaction;
    }

    @Override
    public CustomerTransactionResponse toResponse(TransactionResult transactionResult) {
        if ( transactionResult == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = transactionResult.limit();
        balance = transactionResult.balance();

        CustomerTransactionResponse customerTransactionResponse = new CustomerTransactionResponse( limit, balance );

        return customerTransactionResponse;
    }
}
