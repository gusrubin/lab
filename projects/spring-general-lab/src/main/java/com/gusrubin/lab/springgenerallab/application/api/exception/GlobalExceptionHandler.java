package com.gusrubin.lab.springgenerallab.application.api.exception;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  @Getter
  public static class ErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorResponse(HttpStatus status, String message, String path) {
      this.timestamp = LocalDateTime.now();
      this.status = status.value();
      this.error = status.getReasonPhrase();
      this.message = message;
      this.path = path;
    }
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(
      ResourceNotFoundException ex, WebRequest request) {
    ErrorResponse error =
        new ErrorResponse(
            HttpStatus.NOT_FOUND,
            ex.getMessage(),
            request.getDescription(false).replace("uri=", ""));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler({IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
  public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
    String message;

    if (ex instanceof MethodArgumentTypeMismatchException mismatch) {
      message =
          String.format("Parâmetro '%s' inválido: '%s'", mismatch.getName(), mismatch.getValue());
    } else {
      message = ex.getMessage();
    }

    Map<String, Object> body =
        Map.of(
            "timestamp", LocalDateTime.now(),
            "status", HttpStatus.BAD_REQUEST.value(),
            "error", "Bad Request",
            "message", message,
            "path", request.getDescription(false).replace("uri=", ""));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolation(
      ConstraintViolationException ex, WebRequest request) {
    ErrorResponse error =
        new ErrorResponse(
            HttpStatus.BAD_REQUEST,
            ex.getMessage(),
            request.getDescription(false).replace("uri=", ""));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleAll(Exception ex, WebRequest request) {
    log.debug(Arrays.toString(ex.getStackTrace())); // opcional: log para debug
    ErrorResponse error =
        new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Erro interno inesperado.",
            request.getDescription(false).replace("uri=", ""));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }
}
