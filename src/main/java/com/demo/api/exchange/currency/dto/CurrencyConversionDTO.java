package com.demo.api.exchange.currency.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class CurrencyConversionDTO {

	private String fromCurrency;
	private String toCurrency;
	private BigDecimal value;
	private BigDecimal mount;
	private BigDecimal mountExchange;

}
