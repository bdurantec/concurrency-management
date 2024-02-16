package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.controller;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Transaction;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

  @InjectMocks
  CustomerController customerController;
  @Mock
  TransactionService transactionService;

  MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
  }

  @Test
  void should_receiveAValidRequest() throws Exception {
    var customerId = 1;
    String json = "{\"valor\": 100, \"tipo\": \"C\", \"descricao\": \"Something\"}";
    var customer = new Customer(1000L, 1000L);

    when(transactionService.performsTransaction(anyInt(), any(Transaction.class))).thenReturn(customer);

    mockMvc.perform(post("/v1/clientes/{id}/transacoes", customerId)
            .contentType("application/json")
            .content(json))
        .andExpect(status().isOk())
        .andExpect(content().json("{'limite':1000, 'saldo':1000}"));
  }

  @Test
  void should_rejectRequest_when_idIsNotIntegerNumber() throws Exception {
    var customerId = "L";
    String json = "{\"valor\": 100, \"tipo\": \"C\", \"descricao\": \"Something\"}";

    mockMvc.perform(post("/v1/clientes/{id}/transacoes", customerId)
            .contentType("application/json")
            .content(json))
        .andExpect(status().isBadRequest());
  }

  @Test
  void should_rejectRequest_when_transactionTypeIsDifferentOf_C_or_D() throws Exception {
    var customerId = 1;
    String json = "{\"valor\": 100, \"tipo\": \"X\", \"descricao\": \"Something\"}";

    mockMvc.perform(post("/v1/clientes/{id}/transacoes", customerId)
            .contentType("application/json")
            .content(json))
        .andExpect(status().isBadRequest());
  }

  @Test
  void should_rejectRequest_when_descriptionHasMoreThan10Characters() throws Exception {
    var customerId = 1;
    String json = "{\"valor\": 100, \"tipo\": \"C\", \"descricao\": \"Has more than 10 characters\"}";

    mockMvc.perform(post("/v1/clientes/{id}/transacoes", customerId)
            .contentType("application/json")
            .content(json))
        .andExpect(status().isBadRequest());
  }
}


