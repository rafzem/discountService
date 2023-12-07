package com.zemlar.discountService.api;

import com.zemlar.discountService.api.dto.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseBody
    ResponseEntity<ErrorDto> handleNoResource(Exception e, HttpServletRequest request) {
        return errorResponse(HttpStatus.NOT_FOUND, "Requested resource not found", request);
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    ResponseEntity<ErrorDto> handleInternalException(Exception e, HttpServletRequest request) {
        return errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", request);
    }

    private ResponseEntity<ErrorDto> errorResponse(
            HttpStatus httpStatus, String message, HttpServletRequest request) {
        return ResponseEntity.status(httpStatus).body(
                new ErrorDto(httpStatus.value(), message, request.getRequestURI())
        );
    }

}
