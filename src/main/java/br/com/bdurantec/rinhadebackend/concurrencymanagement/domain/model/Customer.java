package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {
	@Setter
	private Long balance;
	private final Long limit;
	private final List<Transaction> transactions;
	
	public Customer(Long balance, Long limit) {
		this.balance = balance;
		this.limit = limit;
		this.transactions = new ArrayList<>();
	}

	public void addTransaction(Transaction transaction){
		this.transactions.add(transaction);
	}
}
