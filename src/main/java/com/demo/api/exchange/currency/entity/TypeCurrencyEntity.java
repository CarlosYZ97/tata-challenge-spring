package com.demo.api.exchange.currency.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "TipoMoneda")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class TypeCurrencyEntity implements Serializable{
	
	private static final long serialVersionUID = -2568652447602442458L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Moneda Origen es requerido")
	@Size(min = 3, message = "Código debe tener mínimo 3 caracteres")
	@Column(name = "currency_from")
	private String currencyFrom;
	
	@NotBlank(message = "Moneda a cambiar es requerido")
	@Size(min = 3, message = "Código debe tener mínimo 3 caracteres")
	@Column(name = "currency_to")
	private String currencyTo;
	
	@Column(name = "valor")
	private BigDecimal value;
}
