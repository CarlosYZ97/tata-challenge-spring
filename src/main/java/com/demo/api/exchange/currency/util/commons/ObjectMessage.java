package com.demo.api.exchange.currency.util.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectMessage {
	private boolean status;
	private Object  message;

}

