package banking.interestCalculators;

import framework.InterestCalculator;

public class PersonalSavingInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.07;
    }
}
