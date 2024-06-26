package com.example.group4_icms.Functions.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {
    private String ID;
    private String FullName;
    private String phone;
    private String address;
    private String email;
    private String password;
    private String type;
    private String policyOwnerName;
    private List<ClaimDTO> claims;
    private LocalDate expirationDate;
    private LocalDate effectiveDate;
    public CustomerDTO() {
        this.claims = new ArrayList<>();
    }
    public CustomerDTO(String ID, String fullName, String phone, String address, String email, String password, String type, String policyHolder) {
        this.ID = ID;
        this.FullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.type = type;
        this.claims = new ArrayList<>();
        this.policyOwnerName = policyOwnerName;
        this.expirationDate = expirationDate;
        this.effectiveDate = effectiveDate;
    }

    public void setID(String ID) {

        this.ID = ID;
    }
    public String getID() {
        return ID;
    }


    public String getFullName() {
        return FullName;
    }







    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPolicyOwnerName(String policyOwnerName) {
        this.policyOwnerName = policyOwnerName;
    }

    public String getPolicyOwnerName() {
        return policyOwnerName;
    }

    public List<ClaimDTO> getClaims() {
        return claims;
    }

    public void setClaims(List<ClaimDTO> claims) {
        this.claims = claims;
    }


}
