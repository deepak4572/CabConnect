package com.codingshuttle.project.uber.uberApp.advices;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {
	
	private HttpStatus status;
	private String message;
	private List<String> subErrors;
	
}
