package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

public record Transaction(
		Long valueInCents,
		String type,
		String description
) {
}