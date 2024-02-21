package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record BalanceDTO(
    @JsonProperty("total")
    Long total,
    @JsonProperty("data_extrato")
    LocalDateTime statementConsultDate,
    @JsonProperty("limite")
    Long limit
) {
}
