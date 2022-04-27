package com.example.springdemoproject.creditcards;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CreditCardService implements ICreditCardService {

    @Override
    public CreditCardResponse validate(String cardNum) {

        var response = new CreditCardResponse();

        try {

            if (ObjectUtils.isEmpty(cardNum) || (cardNum.length() != 13 && cardNum.length() != 16)) {
                response.setValid(false);
                return response;
            }
            var firstDigit = cardNum.substring(0,1);
            var company = this.getCardCompany(cardNum, firstDigit);

            response = switch (company) {
                case VISA -> new VisaValidator().isValid(cardNum);
                case MASTERCARD -> new MasterCardValidator().isValid(cardNum);
                case DISCOVER -> new DiscoverValidator().isValid(cardNum);
                default -> null;
            };

            return response;
        } catch (Exception e) {
            //log it, maybe throw
        }
        return response;
    }

    private CardCompany getCardCompany(String cardNum, String firstDigit) {

        var cardCompany = switch (firstDigit) {
            case "4":
                yield CardCompany.VISA;
            case "5":
                yield CardCompany.MASTERCARD;
            case "6":
                yield CardCompany.DISCOVER;
            default:
                yield null;
        };

        return cardCompany;

    }
}
