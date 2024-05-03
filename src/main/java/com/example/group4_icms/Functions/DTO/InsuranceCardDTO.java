package com.example.group4_icms.Functions.DTO;

import com.example.group4_icms.entities.Customer.Customer;

import java.time.LocalDate;

public class InsuranceCardDTO {
    private final String CardNum;
    /*number (10 digits)*/

    private final Customer cardHolder;
    private LocalDate ExpirationDate = null;
    private final String PolicyOwner;

    public InsuranceCardDTO(String cardNum, Customer cardHolder, String policyOwner, LocalDate expirationDate) {
        this.CardNum = cardNum;
        this.cardHolder = cardHolder;
        this.PolicyOwner = policyOwner;
        this.ExpirationDate = expirationDate;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }


    public void setExpirationDate(LocalDate expirationDate) {
        ExpirationDate = expirationDate;
    }

    public String getPolicyOwner() {
        return PolicyOwner;
    }

    public String getCardNum() {
        return this.CardNum;
    }
}
