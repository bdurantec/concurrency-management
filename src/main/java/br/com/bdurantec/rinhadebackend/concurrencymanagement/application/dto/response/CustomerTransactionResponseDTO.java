package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerTransactionResponseDTO(
		@JsonProperty("limite")
		Long limit,
		@JsonProperty("saldo")
		Long balance
) {
}
