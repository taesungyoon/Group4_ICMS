//<<<<<<< HEAD
package com.example.group4_icms.entities.InsuranceEmployee;

import com.example.group4_icms.entities.Claim;

import java.util.ArrayList;


//>>>>>>> d068d2efec3093d3ca46e6b815efc74fcb7fea8c
public class InsuranceManager extends InsuranceEmployee{
    private ArrayList<Claim> ConfirmedClaims = new ArrayList<>();

    public ArrayList<Claim> getConfirmedClaims() {
        return ConfirmedClaims;
    }



    public InsuranceManager(String ID, String name, String password) {
        super(ID, name, password);
    }
}
