
package com.example.group4_icms.entities.Customer;


import com.example.group4_icms.entities.InsuranceCard;

public class CustomerDependents extends Customer{
    public CustomerDependents() {}

    Customer PolicyHolder = new CustomerPolicyHolder();

    public void setPolicyHolder(CustomerDependents policyHolder) {
        PolicyHolder = policyHolder;
    }

    public Customer getPolicyHolder() {
        return PolicyHolder;
    }

    public CustomerDependents(String ID, String fullName, InsuranceCard insuranceCard, String phone, String address, String email, String password, Customer policyHolder) {
        super(ID, fullName, insuranceCard, phone, address, email, password);
        this.PolicyHolder = policyHolder;
    }

}
