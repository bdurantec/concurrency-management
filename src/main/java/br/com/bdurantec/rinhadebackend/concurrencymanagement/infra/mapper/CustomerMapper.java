package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
	
	Customer toModel(CustomerEntity customerEntity);
	
	CustomerEntity toEntity(Customer customer);
}
