package IFMG_LuizEduardo_RenatoZampiere.resources.exceptions;


import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionListener {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFound ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError error = new StandartError();

        error.setStatus(status.value());
        error.setMessage(ex.getMessage());
        error.setError("Resource not found");
        error.setTimestamp(Instant.now());

        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);

    }


    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandartError> databaseException(DataBaseException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandartError error = new StandartError();

        error.setStatus(status.value());
        error.setMessage(ex.getMessage());
        error.setError("DataBase  ERROR");
        error.setTimestamp(Instant.now());

        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);

    }


}

