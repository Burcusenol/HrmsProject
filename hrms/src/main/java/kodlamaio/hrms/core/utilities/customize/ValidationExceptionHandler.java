package kodlamaio.hrms.core.utilities.customize;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
	
	public ResponseEntity<?> customValidationErrorHandling(MethodArgumentNotValidException exceptions){
    	Map<String,String> validationErrors=new HashMap<String, String>();
    	for(FieldError fieldError:exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
    	ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Validation exception");
		

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
		
	}


    
  
}
