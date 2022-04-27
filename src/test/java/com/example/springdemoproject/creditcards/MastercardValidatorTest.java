package com.example.springdemoproject.creditcards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class MastercardValidatorTest {

    @Test
    void test_isValidSixteen(){
        var result = new MasterCardValidator().isValid("5100000000000000");
        assertEquals(true, result.isValid());
        assertEquals(CardCompany.MASTERCARD, result.getCardCompany());
    }

    @Test
    void test_isNotValid(){
        var result = new MasterCardValidator().isValid("500");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }
    
    @Test
    void test_isNotMastercard(){
        var result = new MasterCardValidator().isValid("600");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }

}
