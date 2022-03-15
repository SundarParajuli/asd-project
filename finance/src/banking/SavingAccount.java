package banking;


import framework.entity.Account;
import framework.entity.InterestCalculator;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Saving.name();
    }
}
