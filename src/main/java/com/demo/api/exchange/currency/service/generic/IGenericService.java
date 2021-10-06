package com.demo.api.exchange.currency.service.generic;

import java.util.List;

import com.demo.api.exchange.currency.exceptions.ServiceException;

public interface IGenericService<T> {
	
	List<T> getAll() throws ServiceException;
	T save(T t) throws ServiceException;
	T finById(Long Id) throws ServiceException;
	T update(T t) throws ServiceException;
	T delete(Long id) throws ServiceException;
}
