package com.example.group4_icms.Functions.Filtering;

import com.example.group4_icms.Functions.DTO.ClaimDTO;
import com.example.group4_icms.Functions.VC.View.ClaimView;
import com.example.group4_icms.entities.Claim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClaimFiltering {
    private ArrayList<ClaimDTO> Claims = new ArrayList<>();

    public ClaimFiltering(ArrayList<ClaimDTO> claims) {
        Claims = claims;
    }
    public ArrayList<ClaimDTO> filterClaimStatus(Claim.Status status) {
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if (!(claim.getStatus().equals(status))) {
                result.add(claim);
            }
        }
        return result;
    }
    public ArrayList<ClaimDTO> filterClaimDateTimeOlder(LocalDate time) {
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if (claim.getClaimDate().isAfter(time)) {
                result.add(claim);
            }
        }
        return result;

    }
    public ArrayList<ClaimDTO> filterClaimAmountLess(int amount) {
        ArrayList<ClaimDTO> result = new ArrayList<>();
        for (ClaimDTO claim : Claims) {
            if (claim.getClaimAmount() < amount) {
                result.add(claim);
            }
        }
        return result;
    }


}
