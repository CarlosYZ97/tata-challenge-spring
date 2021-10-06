package com.demo.api.exchange.currency.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.api.exchange.currency.util.commons.ObjectMessage;
import com.demo.api.exchange.currency.util.commons.ObjectResponse;
import com.demo.api.exchange.currency.util.constants.CodeConstant;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ObjectResponse> manejarTodasExcepciones(Exception ex, WebRequest request){
		
		return new ResponseEntity<ObjectResponse>(ObjectResponse.builder()
				.message(ObjectMessage.builder().status(CodeConstant.ERROR).message(ex.getMessage()).build()).data(null).build(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ObjectResponse> manejarModeloNotFoundException(ServiceException ex, WebRequest request){
		return new ResponseEntity<ObjectResponse>(ObjectResponse.builder()
				.message(ObjectMessage.builder().status(CodeConstant.ERROR).message(ex.getMessage()).build()).data(null).build(), HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensaje = ex.getBindingResult().getAllErrors().stream().map(e -> {
			return e.getDefaultMessage().toString().concat(", ");
		}).collect(Collectors.joining());
		
//		ObjectMessage er = new ObjectMessage(LocalDateTime.now(), mensaje, request.getDescription(false));
//		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Object>(ObjectResponse.builder()
				.message(ObjectMessage.builder().status(CodeConstant.ERROR).message(mensaje).build()).data(null).build(), HttpStatus.BAD_REQUEST);
		
	}

}
