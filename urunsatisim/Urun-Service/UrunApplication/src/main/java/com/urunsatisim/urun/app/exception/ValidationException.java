package com.urunsatisim.urun.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException extends USSubError{

	private String object;
	private String field;
	private Object rejectedValue;
	private String message;
	
	
}
