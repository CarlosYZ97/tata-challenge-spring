package com.demo.api.exchange.currency.util.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectResponse {

	private ObjectMessage	message;
	private Object  		data;
	
}
