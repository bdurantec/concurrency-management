package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

public record Transaction(
		Long value,
		String type,
		String description
) {
}