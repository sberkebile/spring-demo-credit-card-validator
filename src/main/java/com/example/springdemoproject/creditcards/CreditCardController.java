package com.example.springdemoproject.creditcards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/cc")
public class CreditCardController {

    private ICreditCardService creditCardService;

    @Autowired
    CreditCardController(ICreditCardService creditCardService){
        this.creditCardService = creditCardService;
    }

    @PostMapping("/validate/{cardNumber}")
    public ResponseEntity<CreditCardResponse> validateCreditcard(@PathVariable String cardNumber){

        try {
            var responseBody = this.creditCardService.validate(cardNumber);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
