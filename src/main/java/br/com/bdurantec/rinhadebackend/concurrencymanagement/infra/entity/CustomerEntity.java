package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "tb_customers")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Setter
  private Integer customerId;

  @Column(name = "limit_balance")
  private Long limitBalance;

  @Setter
  @Column(name = "initial_balance")
  private Long initialBalance;

  public CustomerEntity() {
  }

  public CustomerEntity(Long limitBalance, Long initialBalance) {
    this.limitBalance = limitBalance;
    this.initialBalance = initialBalance;
  }
}
