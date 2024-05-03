package com.example.group4_icms.Functions.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClaimDTO {


    private String Id;
    private LocalDateTime ClaimDate;
    private String InsuredPersonId;
    private String CardNum;
    private LocalDate ExamDate;
    private double ClaimAmount;
    private Status status;
    private String insuredPersonId;
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

    public LocalDate getExamDate() {
        return ExamDate;
    }

    public void setExamDate(LocalDate examDate) {
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

    public LocalDateTime getClaimDate() {
        return ClaimDate;
    }

    public void setClaimDate(LocalDateTime claimDateTime) {
        ClaimDate = claimDateTime;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
