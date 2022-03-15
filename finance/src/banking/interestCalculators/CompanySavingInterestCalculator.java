package banking.interestCalculators;

import framework.entity.InterestCalculator;

public class CompanySavingInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.07;
    }
}
