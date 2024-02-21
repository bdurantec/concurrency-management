package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Balance {
  private final Long total;
  private final Long limit;
  private final LocalDateTime statementConsultDate = LocalDateTime.now();

  public Balance(Long total, Long limit) {
    this.total = total;
    this.limit = limit;
  }
}
