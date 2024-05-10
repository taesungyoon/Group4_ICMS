package com.example.group4_icms.Functions.DTO;

import java.sql.Timestamp;

public class ProcessingClaimDTO {
    private int processingClaim_id;
    private String Claim_ID;
    private String Applicator_ID;
    private String Surveyor_ID;
    private String Manager_ID;
    private Timestamp created_at;
    private String Message;

    public ProcessingClaimDTO() {
    }

    public int getProcessingClaim_id() {
        return processingClaim_id;
    }

    public void setProcessingClaim_id(int id) {
        this.processingClaim_id = id;
    }

    public String getClaim_ID() {
        return Claim_ID;
    }

    public void setClaim_ID(String claim_ID) {
        Claim_ID = claim_ID;
    }

    public String getApplicator_ID() {
        return Applicator_ID;
    }

    public void setApplicator_ID(String applicator_ID) {
        Applicator_ID = applicator_ID;
    }

    public String getSurveyor_ID() {
        return Surveyor_ID;
    }

    public void setSurveyor_ID(String surveyor_ID) {
        Surveyor_ID = surveyor_ID;
    }

    public String getManager_ID() {
        return Manager_ID;
    }

    public void setManager_ID(String manager_ID) {
        Manager_ID = manager_ID;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public ProcessingClaimDTO(int id, String claim_ID, String applicator_ID, String surveyor_ID, String manager_ID, Timestamp created_at, String message) {
        this.processingClaim_id = id;
        Claim_ID = claim_ID;
        Applicator_ID = applicator_ID;
        Surveyor_ID = surveyor_ID;
        Manager_ID = manager_ID;
        this.created_at = created_at;
        Message = message;
    }
}
