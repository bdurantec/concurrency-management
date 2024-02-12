package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransactionResult(
		@JsonProperty("limite")
		Long limit,
		@JsonProperty("saldo")
		Long balance
) {
}
