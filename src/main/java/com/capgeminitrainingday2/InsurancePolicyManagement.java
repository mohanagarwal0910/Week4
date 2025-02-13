package com.capgeminitrainingday2;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public String getCoverageType() {
        return coverageType;
    }
    @Override
    public String toString() {
        return String.format("Policy[%s, %s, %s, %s, $%.2f]", policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate); // Sort by expiry date
    }
}
public class InsurancePolicyManagement {
    private Set<Policy> hashSetPolicies = new HashSet<>();
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<Policy> treeSetPolicies = new TreeSet<>();
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }
    public void displayAllPolicies() {
        System.out.println("\nAll Unique Policies (HashSet):");
        hashSetPolicies.forEach(System.out::println);
    }
    public void displayPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Soon (Within 30 Days):");
        treeSetPolicies.stream()
                .filter(policy -> ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30)
                .forEach(System.out::println);
    }
    public void displayPoliciesByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        hashSetPolicies.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }
    public void findDuplicatePolicies() {
        Map<String, Integer> policyCount = new HashMap<>();
        List<Policy> duplicatePolicies = new ArrayList<>();

        for (Policy policy : hashSetPolicies) {
            policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
        }

        for (Policy policy : hashSetPolicies) {
            if (policyCount.get(policy.getPolicyNumber()) > 1) {
                duplicatePolicies.add(policy);
            }
        }

        if (duplicatePolicies.isEmpty()) {
            System.out.println("\nNo Duplicate Policies Found.");
        } else {
            System.out.println("\nDuplicate Policies:");
            duplicatePolicies.forEach(System.out::println);
        }
    }
    public void comparePerformance() {
        List<Policy> testPolicies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            testPolicies.add(new Policy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 500 + (i % 200)));
        }

        compareSetPerformance("HashSet", new HashSet<>(), testPolicies);
        compareSetPerformance("LinkedHashSet", new LinkedHashSet<>(), testPolicies);
        compareSetPerformance("TreeSet", new TreeSet<>(), testPolicies);
    }
    private void compareSetPerformance(String setName, Set<Policy> set, List<Policy> testPolicies) {
        long startTime, endTime;

        startTime = System.nanoTime();
        set.addAll(testPolicies);
        endTime = System.nanoTime();
        System.out.println(setName + " Add Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        set.contains(testPolicies.get(5000));
        endTime = System.nanoTime();
        System.out.println(setName + " Search Time: " + (endTime - startTime) / 1_000_000.0 + " ms");

        startTime = System.nanoTime();
        set.remove(testPolicies.get(5000));
        endTime = System.nanoTime();
        System.out.println(setName + " Remove Time: " + (endTime - startTime) / 1_000_000.0 + " ms\n");
    }
    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        // Sample Policies
        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 1000.0));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 1200.0));
        system.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().plusDays(20), "Home", 1500.0));
        system.addPolicy(new Policy("P1004", "David", LocalDate.now().plusDays(5), "Health", 1100.0));
        system.addPolicy(new Policy("P1001", "Eve", LocalDate.now().plusDays(15), "Auto", 1300.0)); // Duplicate Policy Number
        system.displayAllPolicies();
        system.displayPoliciesExpiringSoon();
        system.displayPoliciesByCoverageType("Health");
        system.findDuplicatePolicies();
        system.comparePerformance();
    }
}
