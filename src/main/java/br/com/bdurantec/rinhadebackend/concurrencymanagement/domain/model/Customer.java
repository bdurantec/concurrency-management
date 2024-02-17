package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Customer {
	@Setter
	private Long balance;
	private final Long limit;
	
	public Customer(Long balance, Long limit) {
		this.balance = balance;
		this.limit = limit;
	}
}
