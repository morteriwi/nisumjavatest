package nisum.java.test.models.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorInfo> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {

        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        StringBuilder errorMessage = new StringBuilder();
        fieldErrors.forEach(f -> errorMessage.append(f.getField() + " " + f.getDefaultMessage() +  " "));

        ErrorInfo errorInfo = new ErrorInfo(errorMessage.toString());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

    }
	
	@ExceptionHandler(ExistingUserException.class)
	public ResponseEntity<ErrorInfo> existingUserException(ExistingUserException e){
		ErrorInfo errorInfo = new ErrorInfo(e.getMessage());
		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
}
