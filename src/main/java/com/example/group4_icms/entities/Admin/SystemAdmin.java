package com.example.group4_icms.entities.Admin;


public class SystemAdmin {
    private String ID = ""; /*Should not be edited*/
    private String FullName = ""; /*Should not be edited*/
    private String phone;
    private String address;
    private String email;
    private String password;

    public SystemAdmin(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
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
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SystemAdmin(String ID, String fullName, String phone, String email, String password, String address) {
        this.ID = ID;
        this.FullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
