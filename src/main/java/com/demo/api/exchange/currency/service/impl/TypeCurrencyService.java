package com.demo.api.exchange.currency.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;
import com.demo.api.exchange.currency.exceptions.ServiceException;
import com.demo.api.exchange.currency.repository.ITypeCurrencyRepository;
import com.demo.api.exchange.currency.service.ITypeCurrencyService;


@Service
public class TypeCurrencyService implements ITypeCurrencyService{

	@Autowired
	private ITypeCurrencyRepository typeCurrencyRepository;
	
	@Override
	public TypeCurrencyEntity save(TypeCurrencyEntity typeCurrencyEntity) throws ServiceException {
		
		TypeCurrencyEntity oldTypeCurrencyEntity = typeCurrencyRepository.findByCurrencyFromAndCurrencyTo(typeCurrencyEntity.getCurrencyFrom(), typeCurrencyEntity.getCurrencyTo()).orElse(null);
		
		if(oldTypeCurrencyEntity != null ) throw new ServiceException("Ya existe un registro para el cambio de moneda " + oldTypeCurrencyEntity.getCurrencyFrom() + " - " + oldTypeCurrencyEntity.getCurrencyTo());
		
		return typeCurrencyRepository.save(typeCurrencyEntity);
	}

	@Override
	public List<TypeCurrencyEntity> getAll() throws ServiceException{
		return typeCurrencyRepository.findAll();
	}

	@Override
	public TypeCurrencyEntity findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency) throws ServiceException{
		return typeCurrencyRepository.findByCurrencyFromAndCurrencyTo(fromCurrency, toCurrency).orElse(null);
	}

	@Override
	public TypeCurrencyEntity finById(Long id) throws ServiceException{
		return typeCurrencyRepository.findById(id).orElse(null);
	}

	@Override
	public TypeCurrencyEntity update(TypeCurrencyEntity typeCurrencyEntity) throws ServiceException {
		
		TypeCurrencyEntity oldtypeCurrencyEntity =  typeCurrencyRepository.findById(typeCurrencyEntity.getId()).orElse(null);
		
		if(oldtypeCurrencyEntity == null) throw new ServiceException("El tipo de moneda " + typeCurrencyEntity.getCurrencyFrom() + " no existe");
		
		return typeCurrencyRepository.save(typeCurrencyEntity);
		
	}

	@Override
	public TypeCurrencyEntity delete(Long id) throws ServiceException {
		TypeCurrencyEntity typeCurrencyEntity =  typeCurrencyRepository.findById(id).orElse(null);
		
		if(typeCurrencyEntity == null) throw new ServiceException("El tipo de moneda con id " + id + " no existe");
		typeCurrencyRepository.delete(typeCurrencyEntity);
		
		return typeCurrencyEntity;
	}

}