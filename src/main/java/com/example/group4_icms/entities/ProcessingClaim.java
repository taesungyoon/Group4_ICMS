package com.example.group4_icms.entities;

public class ProcessingClaim {
    String ClaimID;
    String Applicator_ID;
    String Surveyor_ID;
    String created_at;
    String Manager_ID;
    String Message;

    public ProcessingClaim(){}
    public ProcessingClaim(String claimID, String applicator_ID, String surveyor_ID, String created_at, String manager_ID, String message) {
        this.ClaimID = claimID;
        this.Applicator_ID = applicator_ID;
        this.Surveyor_ID = surveyor_ID;
        this.created_at = created_at;
        this.Manager_ID = manager_ID;
        this.Message = message;
    }

}
