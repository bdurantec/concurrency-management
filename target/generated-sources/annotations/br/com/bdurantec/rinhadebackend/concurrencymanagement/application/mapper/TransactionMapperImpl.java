package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponse;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T20:57:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toModel(CustomerTransactionRequest customerTransactionRequest) {
        if ( customerTransactionRequest == null ) {
            return null;
        }

        Long valueInCents = null;
        String type = null;
        String description = null;

        Transaction transaction = new Transaction( valueInCents, type, description );

        return transaction;
    }

    @Override
    public CustomerTransactionResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = customer.getLimit();
        balance = customer.getBalance();

        CustomerTransactionResponse customerTransactionResponse = new CustomerTransactionResponse( limit, balance );

        return customerTransactionResponse;
    }
}
