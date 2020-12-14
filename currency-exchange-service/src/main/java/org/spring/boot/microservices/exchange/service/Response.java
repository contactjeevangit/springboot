package org.spring.boot.microservices.exchange.service;


public class Response<T> {

	private T response;

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}
	
	
}
