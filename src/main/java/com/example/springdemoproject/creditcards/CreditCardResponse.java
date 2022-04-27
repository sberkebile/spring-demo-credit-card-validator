package com.example.springdemoproject.creditcards;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditCardResponse {

    private CardCompany cardCompany;

    @JsonProperty("valid")
    private boolean isValid;

}
