package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.TransactionResult;

public interface TransactionService {
	
	TransactionResult performsTransaction(String customerId, Transaction transaction);
}
