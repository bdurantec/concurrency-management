package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;

import java.time.LocalDateTime;

public record Transaction(Long value, TransactionTypeEnum type, String description, LocalDateTime dateTime) {
}