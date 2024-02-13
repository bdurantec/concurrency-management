package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-13T15:41:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toModel(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Long balance = null;
        Long limit = null;

        Customer customer = new Customer( balance, limit );

        return customer;
    }

    @Override
    public CustomerEntity toEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Long limitBalance = null;
        Long initialBalance = null;

        CustomerEntity customerEntity = new CustomerEntity( limitBalance, initialBalance );

        return customerEntity;
    }
}
