package com.example.springdemoproject.creditcards;

import org.springframework.util.ObjectUtils;

public class DiscoverValidator extends CreditCardValidator {
    @Override
    CreditCardResponse isValid(String cardNum) {
        this.response = new CreditCardResponse();
        if(cardNum.startsWith("6011")||cardNum.startsWith("65") && cardNum.length() == 16){
            this.response.setValid(true);
            this.response.setCardCompany(CardCompany.DISCOVER);
        }
        return response;
    }

}
