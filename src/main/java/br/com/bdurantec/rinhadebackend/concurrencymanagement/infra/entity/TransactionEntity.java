package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Entity
@Table(name = "tb_transactions")
public class TransactionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer transactionId;

  @Column(name = "valor", nullable = false)
  private Long value;

  @Column(name = "tipo", nullable = false)
  private TransactionTypeEnum type;

  @Column(name = "descricao", nullable = false)
  private String description;

  @Column(name = "dataHora", nullable = false)
  @CreationTimestamp
  private Timestamp dateTime;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "customer_id")
  private CustomerEntity customer;

  public TransactionEntity() {
  }

  public TransactionEntity(Long value, TransactionTypeEnum type, String description) {
    this.value = value;
    this.type = type;
    this.description = description;
  }
}
