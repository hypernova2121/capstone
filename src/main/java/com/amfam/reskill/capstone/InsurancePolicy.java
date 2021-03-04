package com.amfam.reskill.capstone;

import java.util.ArrayList;

public class InsurancePolicy {
    
    // Private member variables
    private Integer id;
    private String policyNumber;
    private String insuredLastName;
    private Double annualPremium;
    private ArrayList<InsuranceClaim> claims;

    // Constructor
    public InsurancePolicy(Integer id, String policyNumber, String insuredLastName, Double annualPremium) {
        this.id = id;
        this.policyNumber = policyNumber;
        this.insuredLastName = insuredLastName;
        this.annualPremium = annualPremium;
        this.claims = new ArrayList<>();
    }

     // Property getters/setters
     public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getInsuredLastName() {
        return insuredLastName;
    }
    public void setInsuredLastName(String insuredLastName) {
        this.insuredLastName = insuredLastName;
    }

    public Double getAnnualPremium(){
        return annualPremium;
    }
    public void setAnnualPremium(Double annualPremium){
        this.annualPremium = annualPremium;
    }
    
    public ArrayList<InsuranceClaim> getClaims() {
        return claims;
    }
    public void setClaims(ArrayList<InsuranceClaim> claims) {
        this.claims = claims;
    }
}
