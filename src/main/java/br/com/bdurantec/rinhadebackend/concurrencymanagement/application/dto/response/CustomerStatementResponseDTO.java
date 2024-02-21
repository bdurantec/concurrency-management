package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CustomerStatementResponseDTO(
    @JsonProperty("saldo")
    BalanceDTO balance,
    @JsonProperty("ultimas_transacoes")
    List<TransactionDTO> transactions
) {
}
