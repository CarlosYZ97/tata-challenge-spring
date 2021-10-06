package com.demo.api.exchange.currency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;

public interface ITypeCurrencyRepository extends JpaRepository<TypeCurrencyEntity, Long> {

	//Optional<TypeCurrencyEntity> findByCode(String code);
	Optional<TypeCurrencyEntity> findById(Long id);
	Optional<TypeCurrencyEntity> findByCurrencyFromAndCurrencyTo(String from, String to);
}
