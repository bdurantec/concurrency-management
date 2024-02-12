package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Account;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.TransactionResult;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.AccountRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionServiceImpl implements TransactionService {
	
	private final AccountRepository accountRepository;
	
	@Override
	public TransactionResult performsTransaction(String customerId, Transaction transaction) {
		Account account = accountRepository.updateAccount(transaction);
		return new TransactionResult(1L, 1L);
	}
	
}
