package com.example.group4_icms.Functions.DTO;

public class ProcessingClaimDTO {
    public ProcessingClaimDTO() {
    }
    String ID;
    String ClaimID;
    String Applicator_ID;
    String Surveyor_ID;
    String created_at;
    String Manager_ID;
    String Message;

    public ProcessingClaimDTO(String ID,String claimID, String applicator_ID, String surveyor_ID, String created_at, String manager_ID, String message) {
        this.ID = ID;
        ClaimID = claimID;
        Applicator_ID = applicator_ID;
        Surveyor_ID = surveyor_ID;
        this.created_at = created_at;
        Manager_ID = manager_ID;
        Message = message;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getClaimID() {
        return ClaimID;
    }

    public void setClaimID(String claimID) {
        ClaimID = claimID;
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getManager_ID() {
        return Manager_ID;
    }

    public void setManager_ID(String manager_ID) {
        Manager_ID = manager_ID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
