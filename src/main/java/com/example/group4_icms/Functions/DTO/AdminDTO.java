package com.example.group4_icms.Functions.DTO;

public class AdminDTO {
    private String ID;
    private String FullName;
    private String phone;
    private String address;
    private String email;
    private String password;

    public AdminDTO() {
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



//    public entities.InsuranceCard getInsuranceCard() {
//        return InsuranceCard;
//    }



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

    public AdminDTO(String ID, String fullName, String phone, String address, String email, String password) {
        this.ID = ID;
        this.FullName = fullName;
//        this.InsuranceCard = insuranceCard;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
    }

}
