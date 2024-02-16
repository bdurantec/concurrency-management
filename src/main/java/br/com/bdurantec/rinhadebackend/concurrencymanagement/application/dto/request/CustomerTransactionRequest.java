package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.request;

import br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums.TransactionTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransactionRequest implements Serializable {

  @Serial
  private static final long serialVersionUID = -5968140534725848734L;

  @JsonProperty("valor")
  @NotNull
  private Long valueInCents;

  @JsonProperty("tipo")
  @NotNull
  private TransactionTypeEnum transactionType;

  @JsonProperty("descricao")
  @NotNull
  @Size(min = 1, max = 10)
  private String description;
}
