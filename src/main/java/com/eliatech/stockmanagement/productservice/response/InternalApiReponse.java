package com.eliatech.stockmanagement.productservice.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InternalApiReponse <T>{
	
	private FriendlyMessage friendlyMessage;
	private T payload;
	private boolean hasError;
	private List<String> errorMessages;
	private HttpStatus httpStatus;
	
	
	
	

}
