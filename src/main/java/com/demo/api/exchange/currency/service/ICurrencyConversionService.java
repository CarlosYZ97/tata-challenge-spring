package com.demo.api.exchange.currency.service;

import java.math.BigDecimal;

import com.demo.api.exchange.currency.dto.CurrencyConversionDTO;
import com.demo.api.exchange.currency.exceptions.ServiceException;

public interface ICurrencyConversionService {

	CurrencyConversionDTO getExchangeConversion(String fromCurrency, String toCurrency, BigDecimal mount) throws ServiceException;
	
}
