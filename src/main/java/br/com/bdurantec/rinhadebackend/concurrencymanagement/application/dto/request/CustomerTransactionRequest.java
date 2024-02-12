package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerTransactionRequest(
		@JsonProperty("valor")
		Long value,
		@JsonProperty("tipo")
		String type,
		@JsonProperty("descricao")
		String description
) {
}
