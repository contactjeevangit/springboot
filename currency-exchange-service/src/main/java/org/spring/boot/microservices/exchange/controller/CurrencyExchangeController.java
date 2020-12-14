package org.spring.boot.microservices.exchange.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.microservices.exchange.model.ExchangeValue;
import org.spring.boot.microservices.exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeService exchangeService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value="/saveExchangeValues", consumes= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(value=HttpStatus.CREATED)
	public ExchangeValue saveExchangeValues(@RequestBody ExchangeValue exchangeValue) {
		return exchangeService.saveExchangeValues(exchangeValue);
	}
	
	@GetMapping("/currency-exchange/from/{currencyFrom}/to/{currencyTo}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String currencyFrom, @PathVariable String currencyTo) {
				
		ExchangeValue exchangeValue = exchangeService.retrieveExchangeValue(currencyFrom, currencyTo);
		
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		logger.info("{}",exchangeValue);
		
		return exchangeValue;
	}
	
	
	
	
	
}
