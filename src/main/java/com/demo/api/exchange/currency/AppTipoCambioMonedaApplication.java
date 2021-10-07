package com.demo.api.exchange.currency;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.demo.api.exchange.currency.entity.TypeCurrencyEntity;
import com.demo.api.exchange.currency.repository.ITypeCurrencyRepository;

@SpringBootApplication
public class AppTipoCambioMonedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTipoCambioMonedaApplication.class, args);
	}


    @Bean
    public CommandLineRunner data(ITypeCurrencyRepository repository) {
        return (args) -> {
            repository.save(new TypeCurrencyEntity(1L,"EUR", "USD",BigDecimal.valueOf(1.16F)));
            repository.save(new TypeCurrencyEntity(2L,"JPY","USD",BigDecimal.valueOf(0.0090F)));
            repository.save(new TypeCurrencyEntity(3L,"MXN","USD",BigDecimal.valueOf(0.049F)));
            repository.save(new TypeCurrencyEntity(4L,"PEN","USD",BigDecimal.valueOf(0.24F)));
            repository.save(new TypeCurrencyEntity(5L,"USD","PEN",BigDecimal.valueOf(4.14F)));
        };
    }
	
}
