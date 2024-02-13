package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
public class CustomerTransactionRequest implements Serializable {
	
	@Serial
	private static final long serialVersionUID = -5968140534725848734L;
	
	@JsonProperty("valor")
	@NotNull
	private final Long valueInCents;
	
	@JsonProperty("tipo")
	@NotNull
	private final String transactionType;
	
	@JsonProperty("descricao")
	@NotNull
	private final String description;
}
