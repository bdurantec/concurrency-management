package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Account;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryImpl implements AccountRepository {
	
	@Override
	public Account updateAccount(Transaction transaction) {
		return null;
	}
}
