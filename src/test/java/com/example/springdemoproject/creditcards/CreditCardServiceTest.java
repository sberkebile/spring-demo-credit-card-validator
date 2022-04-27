package com.example.springdemoproject.creditcards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class CreditCardServiceTest {

    private String invalidCardNum;

    private ICreditCardService testService = new CreditCardService();

    @Test
    void test_cardNumberInvalid(){
        var result = testService.validate("123456789");
        assertNull(result.getCardCompany());
        assertEquals(false, result.isValid());
    }

    @Test
    void test_validVisa(){
        var result = testService.validate("4012345678912");
        assertEquals(CardCompany.VISA, result.getCardCompany());
        assertEquals(true, result.isValid());
    }
    @Test
    void test_validMasterCard(){
        var result = testService.validate("5109876758493826");
        assertEquals(CardCompany.MASTERCARD, result.getCardCompany());
        assertEquals(true, result.isValid());
    }
    @Test
    void test_validDiscover(){
        var result = testService.validate("6011208889304958");
        assertEquals(CardCompany.DISCOVER, result.getCardCompany());
        assertEquals(true, result.isValid());
    }

}
