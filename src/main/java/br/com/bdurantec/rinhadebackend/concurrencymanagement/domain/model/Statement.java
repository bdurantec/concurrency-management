package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import java.util.List;

public record Statement(
    Balance balance,
    List<Transaction> transaction
) {
}
