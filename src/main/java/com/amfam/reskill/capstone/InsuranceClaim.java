package com.amfam.reskill.capstone;

public class InsuranceClaim {
    //Private member variables
    private Integer id;
    private String claimNumber;
    private Boolean isPaid;
    private Double amount;

    //Constructor
    public InsuranceClaim(Integer id, String claimNumber, Boolean isPaid, Double amount){
        this.id = id;
        this.claimNumber = claimNumber;
        this.isPaid = isPaid;
        this.amount = amount;
    }

    // Property getters/setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getClaimNumber(){
        return claimNumber;
    }
    public void setClaimNumber(String claimNumber){
        this.claimNumber = claimNumber;
    }

    public Boolean getIsPaid(){
        return isPaid;
    }
    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Double getAmount(){
        return amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
}
