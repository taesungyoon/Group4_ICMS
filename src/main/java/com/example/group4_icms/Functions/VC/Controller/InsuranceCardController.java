
package com.example.group4_icms.Functions.VC.Controller;
import com.example.group4_icms.Functions.VC.View.InsuranceCardView;
import com.example.group4_icms.entities.InsuranceCard;

public class InsuranceCardController {
    private InsuranceCard insuranceCard;
    private InsuranceCardView insuranceCardView;

    public InsuranceCardController(InsuranceCard insuranceCard, InsuranceCardView insuranceCardView) {
        this.insuranceCard = insuranceCard;
        this.insuranceCardView = insuranceCardView;
    }
}

