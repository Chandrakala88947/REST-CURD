package com.chandu.Exception;



import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle custom ProductNotFoundException
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity handleProductNotFoundException(ProductNotFoundException ex) {
		ErrorMessage message = new ErrorMessage(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND.name());
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	// Handle ArrayIndexOutOfBoundsException
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ErrorMessage> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        ErrorMessage message = new ErrorMessage("Array index is out of bounds: " + ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST.name());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    
 // Handle all other unhandled exceptions (generic catch-all)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
        ErrorMessage message = new ErrorMessage("An unexpected error occurred: " + ex.getMessage(), new Date(), HttpStatus.INTERNAL_SERVER_ERROR.name());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
