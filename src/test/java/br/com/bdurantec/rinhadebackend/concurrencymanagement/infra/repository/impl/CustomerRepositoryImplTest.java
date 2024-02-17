package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.impl;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.exception.CustomerNotFoundException;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.repository.CustomerJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryImplTest {

  @InjectMocks
  CustomerRepositoryImpl customerRepository;

  @Mock
  CustomerJpaRepository jpaRepository;

  @Test
  void should_throwCustomerNotFoundException_when_customerNotExistInDatabase() {
    when(jpaRepository.findById(anyInt())).thenReturn(Optional.empty());

    Assertions.assertThrows(CustomerNotFoundException.class,
        () -> customerRepository.findCustomer(anyInt()),
        "Throws CustomerNotFoundException"
    );
  }
}