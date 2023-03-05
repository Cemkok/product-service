package com.eliatech.stockmanagement.productservice.exception.handler;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eliatech.stockmanagement.productservice.exception.enums.FriendlyMessageCode;
import com.eliatech.stockmanagement.productservice.exception.exceptions.ProductNotCreatedException;
import com.eliatech.stockmanagement.productservice.exception.utils.FriendlyMessageUtils;
import com.eliatech.stockmanagement.productservice.response.FriendlyMessage;
import com.eliatech.stockmanagement.productservice.response.InternalApiResponse;


//Exception handlerları tek bir hata componentinde birleştirmemizi sağlar 
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductNotCreatedException.class)
	public InternalApiResponse<String> handlerProductNotCreatedException(ProductNotCreatedException exception){
		
		return InternalApiResponse.<String>builder()
				.friendlyMessage(FriendlyMessage.builder()
				.title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(), FriendlyMessageCode.ERROR))
				.description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),exception.getFriendlyMessageCode()))
				.build())
				.httpStatus(HttpStatus.BAD_REQUEST)
				.hasError(true)
				.errorMessages(Collections.singletonList(exception.getMessage()))
				.build();
		
	}

}
