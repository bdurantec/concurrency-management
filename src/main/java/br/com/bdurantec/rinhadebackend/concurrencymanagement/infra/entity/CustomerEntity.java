package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_customers")
public class CustomerEntity {
	
	@Id
	@Setter
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "limit_balance")
	private Long limitBalance;
	
	@Setter
	@Column(name = "balance")
	private Long balance;
	
	@OneToMany(
			mappedBy = "customer",
			fetch = FetchType.EAGER,
			cascade = CascadeType.REFRESH
	)
	private final List<TransactionEntity> transactions = new ArrayList<>();
	
	private CustomerEntity() {
	}
	
	public CustomerEntity(Long limitBalance, Long balance) {
		this.limitBalance = limitBalance;
		this.balance = balance;
	}
}
