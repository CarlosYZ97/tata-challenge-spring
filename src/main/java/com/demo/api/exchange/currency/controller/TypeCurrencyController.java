package com.demo.api.exchange.currency.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.demo.api.exchange.currency.controller.generic.GenericController;
import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;
import com.demo.api.exchange.currency.service.ITypeCurrencyService;
import com.demo.api.exchange.currency.util.commons.ObjectResponse;
import com.demo.api.exchange.currency.util.enums.CrudEnum;

@RestController
@RequestMapping("/type-currency/v1")
public class TypeCurrencyController extends GenericController {

	@Autowired
	private ITypeCurrencyService typeCurrencyService;

	@GetMapping
	public ResponseEntity<ObjectResponse> getAllTypeCurrency() {
		List<TypeCurrencyEntity> listTypeCurrencyEntity = typeCurrencyService.getAll();
		return super.ok(listTypeCurrencyEntity, CrudEnum.CONSULTA);
	}

	@GetMapping("/from/{fromCurrency}/to/{toCurrency}")
	public ResponseEntity<ObjectResponse> geTypeCurrencyByFromCurrencyAndToCurrency(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		TypeCurrencyEntity typeCurrencyEntity = typeCurrencyService.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		return super.ok(typeCurrencyEntity, CrudEnum.CONSULTA);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ObjectResponse> getTypeCurrencyById(@PathVariable Long id) {
		TypeCurrencyEntity typeCurrencyEntity = typeCurrencyService.finById(id);
		return super.ok(typeCurrencyEntity, CrudEnum.CONSULTA);

	}

	@PostMapping
	public ResponseEntity<ObjectResponse> createTypeOcurrency(@Valid @RequestBody TypeCurrencyEntity typeCurrencyEntity) {
		TypeCurrencyEntity newtypeCurrencyEntity = typeCurrencyService.save(typeCurrencyEntity);
		return super.ok(newtypeCurrencyEntity, CrudEnum.REGISTRO);
	}

	@PutMapping
	public ResponseEntity<ObjectResponse> updateTypeOcurrency(@Valid @RequestBody TypeCurrencyEntity typeCurrencyEntity) {
		TypeCurrencyEntity updateTypeCurrencyEntity = typeCurrencyService.update(typeCurrencyEntity);
		return super.ok(updateTypeCurrencyEntity, CrudEnum.ACTUALIZACION);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ObjectResponse> deleteTypeOcurrency(@PathVariable Long id) {
		TypeCurrencyEntity deleteTypeCurrencyEntity = typeCurrencyService.delete(id);
		return super.ok(deleteTypeCurrencyEntity, CrudEnum.ELIMINACION);
	}
}
