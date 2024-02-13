package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.CustomerNotFoundException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper.CustomerMapper;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper.CustomerMapperImpl;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.CustomerJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {
	
	private final CustomerJpaRepository customerJpaRepository;
	private final CustomerMapper mapper;
	
	public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository = customerJpaRepository;
		this.mapper = new CustomerMapperImpl();
	}
	
	@Override
	public Customer findCustomer(Integer clientId) {
		var customerEntity = customerJpaRepository.findById(clientId)
				                     .orElseThrow(CustomerNotFoundException::new);
		return mapper.toModel(customerEntity);
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		var customerEntity = customerJpaRepository.saveAndFlush(mapper.toEntity(customer));
		return mapper.toModel(customerEntity);
	}
	
}
