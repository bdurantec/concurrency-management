package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T23:58:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toModel(CustomerEntity customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        Long limit = null;
        Long balance = null;

        limit = customerEntity.getLimitBalance();
        balance = customerEntity.getInitialBalance();

        Customer customer = new Customer( balance, limit );

        return customer;
    }
}
