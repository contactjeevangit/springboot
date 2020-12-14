package org.spring.boot.microservices.exchange.service;

import java.util.List;

import org.spring.boot.microservices.exchange.model.ExchangeValue;
import org.spring.boot.microservices.exchange.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepository;
	
	
	public Response<List<ExchangeValue>> getAllExchangeValues(){		
		List<ExchangeValue>	exchangeDetails = exchangeRepository.findAll();
		Response<List<ExchangeValue>> responseExchangeDetails = new Response<List<ExchangeValue>>();
		responseExchangeDetails.setResponse(exchangeDetails);
		
		return responseExchangeDetails;
	}
	
	 
	public ExchangeValue saveExchangeValues(ExchangeValue exchangeValue){
		return exchangeRepository.save(exchangeValue);
	}
	
	public ExchangeValue retrieveExchangeValue(String currencyFrom, String currencyTo){	
		ExchangeValue responseExchangeValue = exchangeRepository.findByFromAndTo(currencyFrom, currencyTo);
		return responseExchangeValue;
	}
	
	
	
	
	
}
