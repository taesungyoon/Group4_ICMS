
package com.example.group4_icms.Functions.VC.Controller;
import com.example.group4_icms.Functions.VC.View.ClaimView;
import com.example.group4_icms.entities.Claim;

public class ClaimController {
    private Claim claim;
    private ClaimView claimView;

    public ClaimController(Claim claim, ClaimView claimView) {
        this.claim = claim;
        this.claimView = claimView;
    }
}

