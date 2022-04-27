package com.example.springdemoproject.creditcards;

import org.springframework.util.ObjectUtils;

public class VisaValidator extends CreditCardValidator {

    @Override
    CreditCardResponse isValid(String cardNum) {
        this.response = new CreditCardResponse();
        if(cardNum.length() == 13 || cardNum.length() == 16){
            this.response.setValid(true);
            this.response.setCardCompany(CardCompany.VISA);
        }
        return response;
    }
}
