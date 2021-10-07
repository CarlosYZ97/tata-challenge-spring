# Spring Boot + H2 + Docker

### Visión General

- Se debe crear una API para aplicar un tipo de cambio a un monto.
- La API debe recibir el valor “monto“, “moneda origen”, “moneda destino“ y devolver el “monto”, “monto con tipo de cambio”, “moneda origen”, “moneda destino“  y “tipo de cambio”.
- Se debe crear la información del tipo de cambio en una in memory database, por ejemplo H2.
- Dockerizar el JAR e invocar a la API desde el contenedor. (Windows o CentOS)
- El uso de la API debe ser mostrada desde Postman.

### Ficheros

    .
    ├───controllers/
    │   ├───generic/
	│   ├─────GenericController.java
	│	├───ExchangeCurrencyController.java
    │   └───TypeCurrencyController.java
    ├───dto/
    │   └───CurrencyConversionDTO.java
    ├───entity/
    │   └───TypeCurrencyEntity.java
    ├───exceptions/
    │   ├───ResponseExcepcionHandler.java
    │   └───ServiceException.java
	├───repository/
    │   └───TypeCurrencyRepository.java
    ├───service/
	│   ├───generic/
	│   ├─────IGenericService.java
	│   ├───impl/
	│   ├─────CurrencyConversionService.java
	│   ├─────TypeCurrencyService.java
    │   ├───ICurrencyConversionService.java
    │   └───ITypeCurrencyService.java
    ├───util/
	│   ├───commons/
	│   ├─────ObjectMessage.java
	│   ├─────ObjectResponse.java
	│   ├───constants/
	│   ├─────CodeConstant.java
	│   ├───enums/
    │   └─────CrudEnums.java
    └───AppTipoCambioMonedaApplication.java

### Instalación 🔧

Descargar Imagen Docker de Api Tipo de Cambio Moneda

```
docker pull carlosyz1997/api-tipo-moneda:0.1.0
```

### Despliegue 📦

Ejecutar la imagen de docker
```
docker run -p 8083:8082 carlosyz1997/api-tipo-moneda:0.1.0
```