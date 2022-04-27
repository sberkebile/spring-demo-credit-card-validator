package com.example.springdemoproject.creditcards;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class CreditCardRequest {

    private String creditCardNumber;

}
