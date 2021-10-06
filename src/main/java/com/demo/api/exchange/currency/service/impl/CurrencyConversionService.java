package com.demo.api.exchange.currency.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.exchange.currency.dto.CurrencyConversionDTO;
import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;
import com.demo.api.exchange.currency.exceptions.ServiceException;
import com.demo.api.exchange.currency.service.ICurrencyConversionService;

@Service
public class CurrencyConversionService implements ICurrencyConversionService{

	@Autowired
	private TypeCurrencyService typeCurrencyService;
	
	@Override
	public CurrencyConversionDTO getExchangeConversion(String fromCurrency, String toCurrency, BigDecimal mount) throws ServiceException {
		
		TypeCurrencyEntity typeCurrencyEntity = typeCurrencyService.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		
		if(typeCurrencyEntity == null) throw new ServiceException("No existe conversión para los tipos de monedas " + fromCurrency + " - " + toCurrency); 
		
		return new CurrencyConversionDTO(typeCurrencyEntity.getCurrencyFrom(), typeCurrencyEntity.getCurrencyTo(), typeCurrencyEntity.getValue(), mount, typeCurrencyEntity.getValue().multiply(mount));
	}
}
