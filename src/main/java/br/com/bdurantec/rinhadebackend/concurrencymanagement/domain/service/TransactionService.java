package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;

public interface TransactionService {
	
	Customer performsTransaction(Integer customerId, Transaction transaction);
}
