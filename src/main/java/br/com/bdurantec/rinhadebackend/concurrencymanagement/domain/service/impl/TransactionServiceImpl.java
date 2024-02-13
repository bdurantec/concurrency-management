package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionServiceImpl implements TransactionService {
	
	private final CustomerRepository customerRepository;
	
	@Override
	public Customer performsTransaction(String customerId, Transaction transaction) {
		return customerRepository.findCustomer(customerId);
	}
	
}
