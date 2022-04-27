package com.example.springdemoproject.creditcards;

public enum CardCompany {

    VISA ("Visa"),
    MASTERCARD ("MasterCard"),
    DISCOVER ("Discover");

    private String cardName;

    CardCompany(String crd) {
        this.cardName = crd;
    }

    public String getCardName() {
        return this.cardName;
    }

}
