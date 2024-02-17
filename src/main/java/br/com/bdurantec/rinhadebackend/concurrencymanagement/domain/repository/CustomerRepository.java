package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;

public interface CustomerRepository {
	
	Customer findCustomer(Integer customerId);
	Customer updateCustomer(Integer customerId, Customer customer);
}
