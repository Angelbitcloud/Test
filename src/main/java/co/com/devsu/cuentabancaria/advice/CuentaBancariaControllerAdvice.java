package co.com.devsu.cuentabancaria.advice;

import co.com.devsu.cuentabancaria.advice.exceptions.CuentaBancariaException;
import co.com.devsu.cuentabancaria.dto.response.MensajeErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CuentaBancariaControllerAdvice {
    
    @ExceptionHandler(CuentaBancariaException.class)
    public ResponseEntity<Object> processCuentaBancariaException(CuentaBancariaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(MensajeErrorResponse.builder()
                                    .mensaje(ex.getMessage())
                                    .build()
                );
    }
}
