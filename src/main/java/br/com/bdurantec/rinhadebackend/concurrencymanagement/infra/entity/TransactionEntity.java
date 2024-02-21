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
	private Integer id;
	
	@Column(name = "valor")
	private String value;
	
	@Column(name = "tipo")
	private String type;
	
	@Column(name = "descricao")
	private String description;
	
	@Column(name = "dataHora")
	@CreationTimestamp
	private Timestamp dateTime;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;
	
	private TransactionEntity() {
	}
	
	public TransactionEntity(Long value, TransactionTypeEnum type, String description) {
		this.value = value.toString();
		this.type = type.getValue();
		this.description = description;
	}
}
