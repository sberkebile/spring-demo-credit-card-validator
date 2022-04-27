package com.example.springdemoproject.creditcards;

import org.springframework.util.ObjectUtils;

public class MasterCardValidator extends CreditCardValidator {

    @Override
    CreditCardResponse isValid(String cardNum) {
        this.response = new CreditCardResponse();
        if(this.hasValidPrefix(cardNum) && cardNum.length() == 16){
            this.response.setValid(true);
            this.response.setCardCompany(CardCompany.MASTERCARD);
        }
        return response;
    }

    private boolean hasValidPrefix(String cardNum) {
        return cardNum.startsWith("51")||cardNum.startsWith("52")
                ||cardNum.startsWith("53")||cardNum.startsWith("54")||cardNum.startsWith("55");
    }
}
