package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "tb_customers")
public class CustomerEntity {

  @Id
  @Setter
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer customerId;

  @Column(name = "limit_balance", nullable = false)
  private Long limitBalance;

  @Setter
  @Column(name = "balance", nullable = false)
  private Long balance;

  @OneToMany(mappedBy = "customer")
  @Column(name = "transactions", nullable = false)
  private List<TransactionEntity> transactions;

  public CustomerEntity() {
  }

  public CustomerEntity(Long limitBalance, Long balance) {
    this.limitBalance = limitBalance;
    this.balance = balance;
  }
}
