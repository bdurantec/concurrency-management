package br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.mapper;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model.Customer;
import br.com.bdurantec.rinhadebackend.concurrencymanagement.infra.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerMapper {

  @Mapping(source = "limitBalance", target = "limit")
  @Mapping(source = "initialBalance", target = "balance")
  Customer toModel(CustomerEntity customerEntity);

  default CustomerEntity toEntity(Customer customer) {
    if (customer == null) {
      return null;
    }
    var limit = customer.getLimit();
    var balance = customer.getBalance();
    return new CustomerEntity(limit, balance);
  }
}
