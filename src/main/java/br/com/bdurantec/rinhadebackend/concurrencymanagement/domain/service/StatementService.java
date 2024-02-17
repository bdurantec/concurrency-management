package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Statement;

public interface StatementService {
  Statement getStatement(Integer customerId);
}
