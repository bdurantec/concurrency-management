package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.impl;


import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.InconsistentBalanceException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

  @InjectMocks
  TransactionServiceImpl transactionService;

  @Mock
  CustomerRepository customerRepository;

  @Test
  void should_doDebitTransaction_when_CustomersFinalBalanceIsGreaterThanTheAvailableLimit() {
    var customerId = 1;
    var transaction = new Transaction(1000L, TransactionTypeEnum.valueOf("D"), "Something");
    var customer = new Customer(3000L, 1000L);

    when(customerRepository.findCustomer(customerId)).thenReturn(customer);
    when(customerRepository.updateCustomer(customer)).thenReturn(customer);

    Customer customerResponse = transactionService.performsTransaction(customerId, transaction);

    Assertions.assertEquals(2000L, customerResponse.getBalance());
    Assertions.assertEquals(1000L, customerResponse.getLimit());

  }

  @Test
  void should_throwInconsistentBalanceException_when_debitRequestWouldLeaveTheBalanceLessThanTheLimit() {
    var customerId = 1;
    var transaction = new Transaction(4000L, TransactionTypeEnum.valueOf("D"), "Something");
    var customer = new Customer(1000L, 1000L);

    when(customerRepository.findCustomer(customerId)).thenReturn(customer);

    Assertions.assertThrows(InconsistentBalanceException.class,
        () -> transactionService.performsTransaction(customerId, transaction),
        "Throws InconsistentBalanceException");

  }
}