package br.com.bdurantec.rinhadebackend.concurrencymanagement.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ErrorResponse {
	
	@JsonProperty("mensagem")
	private final String message;
	@JsonProperty("statusCode")
	private final Integer statusCode;
	@JsonProperty("time")
	private final LocalDateTime localDateTime;
	@JsonProperty("trace")
	private final String traceId;
	
	public ErrorResponse(String message, Integer statusCode) {
		this.message = message;
		this.statusCode = statusCode;
		this.localDateTime = LocalDateTime.now();
		this.traceId = UUID.randomUUID().toString();
	}
}
