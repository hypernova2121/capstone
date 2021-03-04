package com.amfam.reskill.capstone;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RestAPI {

    @GetMapping("/")
    public String homepage() {
        return ("This is the Java/Spring Boot Capstone project homepage for Dan O'Sullivan");
    }

    @RequestMapping("/policies")
    @GetMapping()
    public Iterable<InsurancePolicy> getInsurancePolicy() {
        return Database.policies;
    }

    @GetMapping("/policies/{id}")
    public Optional<InsurancePolicy> getPolicyById(@PathVariable Integer id) {
         for (InsurancePolicy policy : Database.policies) {
             if (policy.getId().equals(id)) {
                 return Optional.of(policy);
             }
         }
         return Optional.empty();                            
    }

    @GetMapping("/policies/claims/{id}")
    public Optional<InsuranceClaim> getClaimById(@PathVariable Integer id) {
        for (InsurancePolicy policy : Database.policies) {
            for (InsuranceClaim claim : policy.getClaims()) {
                if (claim.getId().equals(id)) {
                    return Optional.of(claim);
                }
            }
        }
        return Optional.empty();
    }

    @GetMapping("/policies/claims/paid")
    public Iterable<InsurancePolicy> getPolicyWithPaidClaim() {
        ArrayList<InsurancePolicy> policyWithPaidClaim = new ArrayList<>();
        for (InsurancePolicy policy : Database.policies) {
            for (InsuranceClaim claim : policy.getClaims()) {
                if (claim.getIsPaid()) {
                    policyWithPaidClaim.add(policy);
                    break;
                }
            }
        }
        return policyWithPaidClaim;
    }
    
    @GetMapping("/policies/{id}/totals")
    public Optional<Map<String, Object>> getTotals(@PathVariable Integer id){
        for (InsurancePolicy policy : Database.policies) {
            if (policy.getId().equals(id)) {
                Map<String, Object> totalMap = new HashMap<>();
                Double claimsTotal = 0.0;
                
                totalMap.put("policyNumber", policy.getPolicyNumber());
                totalMap.put("annualPremium", policy.getAnnualPremium());
                for (InsuranceClaim claim : policy.getClaims()) {
                    claimsTotal += claim.getAmount();
                }
                totalMap.put("claimsTotal", claimsTotal);

                return Optional.of(totalMap);
            }
        }
        return Optional.empty();    
    }
}
