package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
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
	public Customer findCustomer(String clientId) {
		CustomerEntity customerEntity = customerJpaRepository.findById(Integer.parseInt(clientId)).orElseThrow();
		return mapper.toModel(customerEntity);
	}
	
}
