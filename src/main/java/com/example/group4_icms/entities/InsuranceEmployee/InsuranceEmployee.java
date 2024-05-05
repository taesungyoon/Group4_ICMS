package com.example.group4_icms.entities.InsuranceEmployee;

import com.example.group4_icms.entities.Claim;

import java.util.ArrayList;

public class InsuranceEmployee {
    public InsuranceEmployee(){}
    private String ID;
    private String Name;
    private String Password;

    public InsuranceEmployee(String ID, String name, String password) {
        this.ID = ID;
        this.Name = name;
        this.Password = password;
    }

    @Override
    public String toString() {
        return "InsuranceEmployee{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
