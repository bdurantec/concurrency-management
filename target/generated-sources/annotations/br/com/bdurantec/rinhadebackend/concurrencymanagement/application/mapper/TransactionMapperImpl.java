package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request.CustomerTransactionRequest;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response.CustomerTransactionResponseDTO;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-20T23:16:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toModel(CustomerTransactionRequest customerTransactionRequest) {
        if ( customerTransactionRequest == null ) {
            return null;
        }

        Long value = null;
        TransactionTypeEnum type = null;
        String description = null;

        value = customerTransactionRequest.getValue();
        type = customerTransactionRequest.getType();
        description = customerTransactionRequest.getDescription();

        LocalDateTime dateTime = null;

        Transaction transaction = new Transaction( value, type, description, dateTime );

        return transaction;
    }

    @Override
    public CustomerTransactionResponseDTO toResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = customer.getLimit();
        balance = customer.getBalance();

        CustomerTransactionResponseDTO customerTransactionResponseDTO = new CustomerTransactionResponseDTO( limit, balance );

        return customerTransactionResponseDTO;
    }
}
