package com.lautadev.microservice_benefit.Throwable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

    @ExceptionHandler(BenefitExceptions.class)
    public ResponseEntity<?> handleBenefitNotFoundException(BenefitExceptions ex, WebRequest request) {
        // Puedes definir una clase de respuesta personalizada para devolver un JSON estructurado
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Maneja otras excepciones aquí

    // Clase interna para los detalles del error
    public static class ErrorDetails {
        private int statusCode;
        private String message;

        public ErrorDetails(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}