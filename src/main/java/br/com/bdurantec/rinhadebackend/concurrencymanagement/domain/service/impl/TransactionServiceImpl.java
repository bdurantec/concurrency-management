package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.InconsistentBalanceException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.TransactionRepository;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TransactionServiceImpl implements TransactionService {

  private final CustomerRepository customerRepository;
//  private final TransactionRepository transactionRepository;

  @Override
  public Customer doTransaction(Integer customerId, Transaction transaction) {
    var customer = customerRepository.findCustomer(customerId);

    var newBalance = customer.getBalance() - transaction.value();

    if (TransactionTypeEnum.D.equals(transaction.type())) {
      var limitNegative = customer.getLimit() * -1L;
      if (newBalance < limitNegative) {
        throw new InconsistentBalanceException("The customer has no limit available to carry out the transaction");
      }
    }

//    var transactionAfterSave = transactionRepository.save(transaction);
//    customer.addTransaction(transactionAfterSave);
    customer.setBalance(newBalance);
    return customerRepository.updateCustomer(customerId, customer);
  }

}
