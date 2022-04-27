package com.example.springdemoproject.creditcards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class VisaValidatorTest {

    @Test
    void test_isValidSixteen(){
        var result = new VisaValidator().isValid("4000000000000000");
        assertEquals(true, result.isValid());
        assertEquals(CardCompany.VISA, result.getCardCompany());
    }
    @Test
    void test_isValidThirteen(){
        var result = new VisaValidator().isValid("4000000000000");
        assertEquals(true, result.isValid());
        assertEquals(CardCompany.VISA, result.getCardCompany());
    }

    @Test
    void test_isNotValid(){
        var result = new VisaValidator().isValid("400");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }

    @Test
    void test_isNotVisa(){
        var result = new VisaValidator().isValid("500");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }

}
