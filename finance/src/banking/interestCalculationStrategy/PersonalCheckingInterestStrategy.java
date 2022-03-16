package banking.interestCalculationStrategy;


import framework.entity.InterestCalculationStrategy;

public class PersonalCheckingInterestStrategy implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.1;
    }
}
