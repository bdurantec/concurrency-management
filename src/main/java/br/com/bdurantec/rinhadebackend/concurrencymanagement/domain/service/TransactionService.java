package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;

public interface TransactionService {
	
	Customer doTransaction(Integer customerId, Transaction transaction);
}
