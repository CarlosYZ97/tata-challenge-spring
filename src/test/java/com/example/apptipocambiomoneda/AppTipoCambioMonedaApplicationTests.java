package com.example.apptipocambiomoneda;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.api.exchange.currency.AppTipoCambioMonedaApplication;

@SpringBootTest(classes = {AppTipoCambioMonedaApplication.class})
class AppTipoCambioMonedaApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}
