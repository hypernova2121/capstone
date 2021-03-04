package com.amfam.reskill.capstone;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<InsurancePolicy> policies = new ArrayList<>();

    /*
        InsurancePolicy structure includes:
            - id (Integer)
            - policyNumber (String)
            - insuredLastName (String)
            - annualPremium (Double)
            - ArrayList of Claims

        InsuranceClaim structure includes:
            - id (Integer)
            - claimNumber (String)
            - isPaid (Boolean)
            - amount (Double)
    */

    public static void loadData() {
        InsurancePolicy policy1 = new InsurancePolicy(1, "888AAA", "Robertson", 168.47);
        InsuranceClaim policy1Claim1 = new InsuranceClaim(1, "CLM123", false, 1500.00);
        InsuranceClaim policy1Claim2 = new InsuranceClaim(2, "CLM222", false, 2497.68);
        policy1.getClaims().add(policy1Claim1);
        policy1.getClaims().add(policy1Claim2);
        policies.add(policy1);

        InsurancePolicy policy2 = new InsurancePolicy(2, "807DDI", "Testing", 269.80);
        InsuranceClaim policy2Claim1 = new InsuranceClaim(3, "CLM444", true, 8433.11);
        policy2.getClaims().add(policy2Claim1);
        policies.add(policy2);

        InsurancePolicy policy3 = new InsurancePolicy(3, "777AAB", "Schmoe", 467.89);
        InsuranceClaim policy3Claim1 = new InsuranceClaim(4, "CLM001", false, 799.00);
        InsuranceClaim policy3Claim2 = new InsuranceClaim(5, "CLM002", true, 4877.44);
        InsuranceClaim policy3Claim3 = new InsuranceClaim(6, "CLM003", true, 2501.01);
        policy3.getClaims().add(policy3Claim1);
        policy3.getClaims().add(policy3Claim2);
        policy3.getClaims().add(policy3Claim3);
        policies.add(policy3);

        InsurancePolicy policy4 = new InsurancePolicy(4, "900AEF", "Williamson", 100.23);
        policies.add(policy4);
    }
}