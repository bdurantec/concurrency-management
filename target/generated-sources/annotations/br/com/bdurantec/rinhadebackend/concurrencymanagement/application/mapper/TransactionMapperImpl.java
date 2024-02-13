package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponse;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-13T12:20:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toModel(CustomerTransactionRequest customerTransactionRequest) {
        if ( customerTransactionRequest == null ) {
            return null;
        }

        Long valueInCents = null;
        String transactionType = null;
        String description = null;

        Transaction transaction = new Transaction( valueInCents, transactionType, description );

        return transaction;
    }

    @Override
    public CustomerTransactionResponse toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = customer.limit();
        balance = customer.balance();

        CustomerTransactionResponse customerTransactionResponse = new CustomerTransactionResponse( limit, balance );

        return customerTransactionResponse;
    }
}
