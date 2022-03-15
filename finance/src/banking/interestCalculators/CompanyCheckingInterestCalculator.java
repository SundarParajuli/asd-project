package banking.interestCalculators;


import framework.entity.InterestCalculator;

public class CompanyCheckingInterestCalculator implements InterestCalculator {
    //TODO::interest calculation is static it should be dynamic
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.07;
    }
}
