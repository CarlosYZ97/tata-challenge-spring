package com.demo.api.exchange.currency.service;

import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;
import com.demo.api.exchange.currency.exceptions.ServiceException;
import com.demo.api.exchange.currency.service.generic.IGenericService;

public interface ITypeCurrencyService extends IGenericService<TypeCurrencyEntity> {
	
	TypeCurrencyEntity findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency) throws ServiceException;
	
}
