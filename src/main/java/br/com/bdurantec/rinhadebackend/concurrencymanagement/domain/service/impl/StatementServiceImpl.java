package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Balance;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Statement;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StatementServiceImpl implements StatementService {

  private final CustomerRepository customerRepository;

  @Override
  public Statement getStatement(Integer customerId) {
    var customer = customerRepository.findCustomer(customerId);

    //TODO sort by date last ten transactions

    var balance = new Balance(customer.getBalance(), customer.getLimit());
    return new Statement(balance, customer.getTransactions());
  }
}
