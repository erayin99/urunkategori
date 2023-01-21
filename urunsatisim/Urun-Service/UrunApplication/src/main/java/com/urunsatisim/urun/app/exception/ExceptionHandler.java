package com.urunsatisim.urun.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			List<USSubError> subErrors = new ArrayList<>();
			ex.getBindingResult().getFieldErrors().stream().forEach(e->{
				
				USSubError error = new ValidationException (
						e.getObjectName(),
						e.getField(),
						e.getRejectedValue(),
						e.getDefaultMessage()
						);
				subErrors.add(error);
				
			});
				USError error = new USError(HttpStatus.BAD_REQUEST, 
						LocalDateTime.now(),  
						ex.getLocalizedMessage(), 
						subErrors);
			
		return ResponseEntity.badRequest().body(error);
	}
		
		@org.springframework.web.bind.annotation.ExceptionHandler(RecordNotFoundException.class)
		public ResponseEntity<Object> HandlerRecodrNotFoundException(RecordNotFoundException ex, WebRequest wr){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
		}
		
		
}
