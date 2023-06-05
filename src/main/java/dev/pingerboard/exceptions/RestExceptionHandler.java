package dev.pingerboard.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

/**
 * @author a.zharov
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ServerNotCreatedException.class)
    public ResponseEntity<ServiceExceptionResponse> handleException(ServerNotCreatedException e,
                                                                    HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ServiceExceptionResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ResponseBody
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ServiceExceptionResponse> handleException(NoSuchElementException e,
                                                                    HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ServiceExceptionResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.NOT_FOUND.value())
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ServiceExceptionResponse> handleException(Exception e,
                                                                    HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ServiceExceptionResponse.builder()
                        .timeStamp(LocalDateTime.now())
                        .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }
}
