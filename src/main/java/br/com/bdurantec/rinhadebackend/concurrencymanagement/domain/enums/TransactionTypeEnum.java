package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums;

public enum TransactionTypeEnum {
	CREDIT("C"),
	DEBIT("D");
	
	private final String type;
	
	TransactionTypeEnum(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return type;
	}
	
}
