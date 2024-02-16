package br.com.bdurantec.rinhadebackend.concurrencymanagement.domain.enums;

public enum TransactionTypeEnum {
	C("CREDIT"),
	D("DEBIT");
	
	private final String type;
	
	TransactionTypeEnum(String type) {
		this.type = type;
	}
	
	public String getValue() {
		return type;
	}
	
}
