package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;

public record Transaction(
    Long valueInCents,
    TransactionTypeEnum type,
    String description
) {
}