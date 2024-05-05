
package com.example.group4_icms.entities;

import com.example.group4_icms.entities.Customer.Customer;
import com.example.group4_icms.entities.InsuranceCard;

import java.time.LocalDate;

public class InsuranceCard {
    private final String CardNum;
/*number (10 digits)*/

    private final Customer cardHolder;
    private LocalDate ExpirationDate = null;
    private final String PolicyOwner;
    private LocalDate EffectiveDate = null;
    public InsuranceCard(String cardNum, Customer cardHolder, LocalDate expirationDate, String policyOwner,LocalDate effectiveDate) {
        this.CardNum = cardNum;
        this.cardHolder = cardHolder;
        this.ExpirationDate = expirationDate;
        this.PolicyOwner = policyOwner;
        this.EffectiveDate = effectiveDate;
    }

    public String getCardNum() {
        return CardNum;
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
}

