package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record TransactionDTO(
    @JsonProperty("valor")
    Long value,
    @JsonProperty("tipo")
    TransactionTypeEnum transactionType,
    @JsonProperty("descricao")
    String description,
    @JsonProperty("realizada_em")
    LocalDateTime executedDateTime
) {
}
