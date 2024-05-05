package com.example.group4_icms.Functions.DTO;

import com.example.group4_icms.entities.Customer.Customer;

import java.time.LocalDate;

public class InsuranceCardDTO {
    private String CardNum;
    /*number (10 digits)*/

    private  String cardHolder;
    private LocalDate ExpirationDate = null;
    private  String PolicyOwner;
    private LocalDate EffectiveDate = null;
    public void setCardNum(String cardNum) {
        CardNum = cardNum;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setPolicyOwner(String policyOwner) {
        PolicyOwner = policyOwner;
    }

    public InsuranceCardDTO(String cardNum, String cardHolder, String policyOwner, LocalDate expirationDate,LocalDate effectiveDate) {
        this.CardNum = cardNum;
        this.cardHolder = cardHolder;
        this.PolicyOwner = policyOwner;
        this.ExpirationDate = expirationDate;
        this.EffectiveDate = effectiveDate;
    }

    public LocalDate getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public InsuranceCardDTO() {

    }

    public String getCardHolder() {
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
