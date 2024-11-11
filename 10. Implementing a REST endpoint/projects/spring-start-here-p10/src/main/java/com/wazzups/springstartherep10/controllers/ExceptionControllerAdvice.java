package com.wazzups.springstartherep10.controllers;

import com.wazzups.springstartherep10.exceptions.NotEnoughMoneyException;
import com.wazzups.springstartherep10.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoney() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money");

        return ResponseEntity
            .badRequest()
            .body(errorDetails);
    }
}
