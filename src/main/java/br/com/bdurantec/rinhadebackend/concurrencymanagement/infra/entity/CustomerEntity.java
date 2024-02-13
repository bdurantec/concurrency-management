package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_customers")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer customerId;
	
	@Column(name = "limit_balance")
	private final Long limitBalance;
	
	@Column(name = "initial_balance")
	private final Long initialBalance;
	
	public CustomerEntity(Long limitBalance, Long initialBalance) {
		this.limitBalance = limitBalance;
		this.initialBalance = initialBalance;
	}
}
