package com.demo.api.exchange.currency.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.exchange.currency.controller.generic.GenericController;
import com.demo.api.exchange.currency.dto.CurrencyConversionDTO;
import com.demo.api.exchange.currency.service.ICurrencyConversionService;
import com.demo.api.exchange.currency.util.commons.ObjectResponse;
import com.demo.api.exchange.currency.util.enums.CrudEnum;

@RestController
@RequestMapping("/exchange-currency/v1")
public class ExchangeCurrencyController extends GenericController{

	@Autowired
	private ICurrencyConversionService currencyConversionService;
	
	@GetMapping("/from/{fromCurrency}/to/{toCurrency}/mount/{mount}")
	public ResponseEntity<ObjectResponse> convertCurrency(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable BigDecimal mount) {
		
		CurrencyConversionDTO currencyConversionDTO = currencyConversionService.getExchangeConversion(fromCurrency, toCurrency, mount);
		return super.ok(currencyConversionDTO, CrudEnum.CONSULTA);
	}
	
}
