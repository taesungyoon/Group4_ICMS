package com.example.group4_icms.Functions.DTO;

<<<<<<< Updated upstream
=======
import java.sql.Array;
import java.sql.Date;
import java.sql.Timestamp;
>>>>>>> Stashed changes
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ClaimDTO {
    public ClaimDTO() {
    }


    private String Id;
    private Timestamp ClaimDate;
    private String InsuredPersonId;
    private String CardNum;
    private Date ExamDate;
    private double ClaimAmount;
<<<<<<< Updated upstream
    private Status status;
    private String insuredPersonId;
=======
    private String insurancePersonID;
    private String SubmittedByID;
    private String Status;
    private String BankingInfo;
    private Array claim_Documents;

//    private String policyHolderId;


    public String getInsurancePersonID() {
        return insurancePersonID;
    }

    public void setInsurancePersonID(String insurancePersonID) {
        this.insurancePersonID = insurancePersonID;
    }

    public String getSubmittedByID() {
        return SubmittedByID;
    }

    public void setSubmittedByID(String submittedByID) {
        SubmittedByID = submittedByID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getBankingInfo() {
        return BankingInfo;
    }

    public void setBankingInfo(String bankingInfo) {
        BankingInfo = bankingInfo;
    }

    public Array getClaim_Documents() {
        return claim_Documents;
    }

    public void setClaim_Documents(Array claim_Documents) {
        this.claim_Documents = claim_Documents;
    }

>>>>>>> Stashed changes
    private String submittedById;

//    private String ReceiverBankingInfo;
    public enum Status {
        NEW, PROCESSING, DONE
    }
    public ClaimDTO(){}
    public ClaimDTO(String id, LocalDateTime ClaimDate, String InsuredPersonId, String submittedById, LocalDate ExamDate, double ClaimAmount, Status status) {
        this.Id = id;
        this.ClaimDate = ClaimDate;
        this.InsuredPersonId = InsuredPersonId;
        this.submittedById = submittedById;
        this.ExamDate = ExamDate;
        this.ClaimAmount = ClaimAmount;
        this.status = status;
    }

    public String getSubmittedById() {
        return submittedById;
    }

    public void setSubmittedById(String submittedById) {
        this.submittedById = submittedById;
    }
<<<<<<< Updated upstream
=======

//    public String getPolicyHolderId() {
//        return policyHolderId;
//    }




//    private String ReceiverBankingInfo;


>>>>>>> Stashed changes
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getClaimAmount() {
        return ClaimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        ClaimAmount = claimAmount;
    }

    public Date getExamDate() {
        return ExamDate;
    }

    public void setExamDate(Date examDate) {
        ExamDate = examDate;
    }

    public String getCardNum() {
        return CardNum;
    }

    public void setCardNum(String cardNum) {
        CardNum = cardNum;
    }

    public String getInsuredPersonId() {
        return InsuredPersonId;
    }

    public void setInsuredPersonId(String insuredPersonId) {
        InsuredPersonId = insuredPersonId;
    }

    public Timestamp getClaimDate() {
        return ClaimDate;
    }

<<<<<<< Updated upstream
    public void setClaimDate(LocalDateTime claimDateTime) {
        ClaimDate = claimDateTime;
    }
    public Status getStatus() {
        return status;
=======
    public void setClaimDate(Timestamp claimDate) {
        ClaimDate = claimDate;
>>>>>>> Stashed changes
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
