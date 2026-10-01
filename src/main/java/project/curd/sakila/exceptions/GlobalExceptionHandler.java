package project.curd.sakila.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.curd.sakila.model.BaseHttpResponseModel;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ActorNotFoundException.class)
    public ResponseEntity<BaseHttpResponseModel> actorNotFound(ActorNotFoundException ex){

        log.error("Exception occurred while accessing actor", ex);

        BaseHttpResponseModel response = new BaseHttpResponseModel();
        response.setStatus("Failed");
        response.setErrorMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseHttpResponseModel> genericException(Exception ex){

        log.error("Exception occurred while processing the request", ex);

        BaseHttpResponseModel response = new BaseHttpResponseModel();
        response.setStatus("Failed");
        response.setErrorMessage("Something went wrong. Please try again later.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
