package com.example.springdemoproject.creditcards;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class DiscoverValidatorTest {

    @Test
    void test_isValidSixteen(){
        var result = new DiscoverValidator().isValid("6011000000000000");
        assertEquals(true, result.isValid());
        assertEquals(CardCompany.DISCOVER, result.getCardCompany());
    }
    @Test
    void test_isValidAltPrefix(){
        var result = new DiscoverValidator().isValid("6511000000000000");
        assertEquals(true, result.isValid());
        assertEquals(CardCompany.DISCOVER, result.getCardCompany());
    }

    @Test
    void test_isNotValid(){
        var result = new DiscoverValidator().isValid("6500");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }
    
    @Test
    void test_isNotDiscover(){
        var result = new DiscoverValidator().isValid("56600");
        assertEquals(false, result.isValid());
        assertNull(result.getCardCompany());
    }

}
