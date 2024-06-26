
package com.example.group4_icms.entities.Customer;

import java.util.ArrayList;

import com.example.group4_icms.entities.InsuranceCard;


public class CustomerPolicyHolder extends Customer{
    private ArrayList<Customer> dependents = new ArrayList<>();


    public CustomerPolicyHolder(String ID, String fullName, InsuranceCard insuranceCard, String phone, String address, String email, String password) {
        super(ID, fullName, insuranceCard, phone, address, email, password);
    }

    public CustomerPolicyHolder() {

    }

    public void addDependent(CustomerDependents customer){
        dependents.add(customer);
        customer.setPolicyHolder(customer);
    }

    public ArrayList<Customer> getDependents() {
        return dependents;
    }
}

