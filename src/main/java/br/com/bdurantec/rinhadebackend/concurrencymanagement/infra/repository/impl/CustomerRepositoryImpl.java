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

  private final CustomerJpaRepository jpaRepository;
  private final CustomerMapper mapper;

  public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
    this.mapper = new CustomerMapperImpl();
  }

  @Override
  public Customer findCustomer(Integer customerId) {
    var customerEntity = jpaRepository.findById(customerId)
        .orElseThrow(CustomerNotFoundException::new);
    return mapper.toModel(customerEntity);
  }

  @Override
  public Customer updateCustomer(Integer customerId, Customer customer) {
    var customerEntity = mapper.toEntity(customer);
    customerEntity.setCustomerId(customerId);
    return mapper.toModel(jpaRepository.save(customerEntity));
  }

}
