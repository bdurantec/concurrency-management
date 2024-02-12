package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Account;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;

public interface AccountRepository {
	
	Account updateAccount(Transaction transaction);
}
