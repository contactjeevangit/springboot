package org.spring.boot.microservices.exchange.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class ExchangeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String currencyFrom;
	private String currencyTo;
	private BigDecimal conversionMultiple;
	private int port;
	
	
	public ExchangeValue() {
		
	}
	
	
	public ExchangeValue(int id, String currencyFrom, String currencyTo, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCurrencyFrom() {
		return currencyFrom;
	}


	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}


	public String getCurrencyTo() {
		return currencyTo;
	}


	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}


	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}


	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
	
}
