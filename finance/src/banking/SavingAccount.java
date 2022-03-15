package banking;


import framework.entity.Account;
import framework.entity.InterestCalculationStrategy;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculationStrategy interestCalculationStrategy) {
        super(interestCalculationStrategy);
    }

    @Override
    public String getAccountType() {
        return AccountType.SAVING.name();
    }
}
