package com.example.springdemoproject.creditcards;

import org.springframework.util.ObjectUtils;

public abstract class CreditCardValidator {

    protected CreditCardResponse response;

    abstract CreditCardResponse isValid(String cardNum);

}
