package com.capgeminitrainingday2;
import java.util.*;
import java.time.LocalDate;
class PolicyMap {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public PolicyMap(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, $%.2f]", policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
    }
}
public class InsaurancePolicyManagementUsingMap {
    private Map<String, PolicyMap> policyMap = new HashMap<>();
    private Map<String, PolicyMap> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, PolicyMap> sortedPoliciesByExpiry = new TreeMap<>();

    public void addPolicy(PolicyMap policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        orderedPolicyMap.put(policy.getPolicyNumber(), policy);
        sortedPoliciesByExpiry.put(policy.getExpiryDate(), policy);
    }
    public PolicyMap getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }
    public void listPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring in the Next 30 Days:");
        sortedPoliciesByExpiry.subMap(today, today.plusDays(30))
                .values()
                .forEach(System.out::println);
    }
    public void listPoliciesByHolder(String policyHolderName) {
        System.out.println("\nPolicies for " + policyHolderName + ":");
        policyMap.values().stream()
                .filter(policy -> policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName))
                .forEach(System.out::println);
    }
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<LocalDate> iterator = sortedPoliciesByExpiry.keySet().iterator();

        while (iterator.hasNext()) {
            LocalDate expiryDate = iterator.next();
            if (expiryDate.isBefore(today)) {
                PolicyMap expiredPolicy = sortedPoliciesByExpiry.get(expiryDate);
                policyMap.remove(expiredPolicy.getPolicyNumber());
                orderedPolicyMap.remove(expiredPolicy.getPolicyNumber());
                iterator.remove();
            }
        }
        System.out.println("\nExpired Policies Removed!");
    }
    public static void main(String[] args) {
        InsaurancePolicyManagementUsingMap system = new InsaurancePolicyManagementUsingMap();
        // Sample Policies
        system.addPolicy(new PolicyMap("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 1000.0));
        system.addPolicy(new PolicyMap("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 1200.0));
        system.addPolicy(new PolicyMap("P1003", "Charlie", LocalDate.now().minusDays(5), "Home", 1500.0));
        system.addPolicy(new PolicyMap("P1004", "David", LocalDate.now().plusDays(5), "Health", 1100.0));
        system.addPolicy(new PolicyMap("P1005", "Alice", LocalDate.now().plusDays(20), "Auto", 1300.0));
        // Retrieve Policy by Number
        System.out.println("\nPolicy P1001 Details: " + system.getPolicyByNumber("P1001"));

        // List Policies Expiring Soon
        system.listPoliciesExpiringSoon();

        // List Policies by Policyholder
        system.listPoliciesByHolder("Alice");

        // Remove Expired Policies
        system.removeExpiredPolicies();

        // List Policies Again
        system.listPoliciesExpiringSoon();
    }

}
