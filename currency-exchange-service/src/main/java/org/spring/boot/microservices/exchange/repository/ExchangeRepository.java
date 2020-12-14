package org.spring.boot.microservices.exchange.repository;


import org.spring.boot.microservices.exchange.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeRepository  extends JpaRepository<ExchangeValue, Integer>{

	@Query("select e from ExchangeValue e where (:currencyFrom is null or e.currencyFrom=:currencyFrom)  "+
			" and (:currencyTo is null or e.currencyTo=:currencyTo) ")
	ExchangeValue findByFromAndTo(String currencyFrom, String currencyTo);
		
	
	
}
