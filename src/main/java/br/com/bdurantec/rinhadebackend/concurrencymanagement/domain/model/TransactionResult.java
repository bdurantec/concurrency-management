package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

public record TransactionResult(
		Long limit,
		Long balance
) {
}
