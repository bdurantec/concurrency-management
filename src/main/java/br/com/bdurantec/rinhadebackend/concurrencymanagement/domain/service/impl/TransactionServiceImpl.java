package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.InconsistentBalanceException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionServiceImpl implements TransactionService {

  private final CustomerRepository customerRepository;

  @Override
  public Customer performsTransaction(Integer customerId, Transaction transaction) {
    var customer = customerRepository.findCustomer(customerId);

    var newBalance = customer.getBalance() - transaction.valueInCents();

    if (TransactionTypeEnum.D.equals(transaction.transactionType())) {
      var limitNegative = customer.getLimit() * -1L;
      if (newBalance < limitNegative) {
        throw new InconsistentBalanceException("The customer has no limit available to carry out the transaction");
      }
    }

    customer.setBalance(newBalance);
    return customerRepository.updateCustomerBalance(customerId, customer);
  }

}
