package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;

public interface TransactionRepository {
  Transaction save(Transaction transaction);
}
