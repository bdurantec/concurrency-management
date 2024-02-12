package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Account(
		@JsonProperty("limite")
		Long limit,
		@JsonProperty("saldo")
		Long balance
) {
}
