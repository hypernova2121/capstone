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
@RequestMapping("/policies")
public class RestAPI {
    @GetMapping
    public Iterable<InsurancePolicy> getInsurancePolicy() {
        return Database.policies;
    }

    @GetMapping("/{id}")
    public Optional<InsurancePolicy> getPolicyById(@PathVariable Integer id) {
         for (InsurancePolicy policy : Database.policies) {
             if (policy.getId().equals(id)) {
                 return Optional.of(policy);
             }
         }
         return Optional.empty();                            
    }

    @GetMapping("/claims/{id}")
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

    @GetMapping("/claims/paid")
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
    
    @GetMapping("/{id}/totals")
    public Optional<Map<String, Object>> getTotals(@PathVariable Integer id){
        for (InsurancePolicy policy : Database.policies) {
            if (policy.getId().equals(id)) {
                Map<String, Object> totalMap = new HashMap<>();
                Double claimAmount = 0.0;

                totalMap.put("Annual Premium", policy.getAnnualPremium());
                for (InsuranceClaim claim : policy.getClaims()) {
                    claimAmount += claim.getAmount();
                }
                totalMap.put("Total Amount for all claims", claimAmount);

                return Optional.of(totalMap);
            }
        }
        return Optional.empty();    
    }
}
