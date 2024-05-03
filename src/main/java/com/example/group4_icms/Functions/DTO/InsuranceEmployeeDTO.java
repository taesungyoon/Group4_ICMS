package com.example.group4_icms.Functions.DTO;

public class InsuranceEmployeeDTO {
    private String ID;
    private String FullName;
    private String Password;
    private String phone;
    private String address;
    private String email;
    public void InsuranceCardDTO(){}

    public InsuranceEmployeeDTO(String ID, String fullName, String password, String phone, String address, String email) {
        this.ID = ID;
        FullName = fullName;
        Password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
