package banking;


import framework.Account;
import framework.InterestCalculator;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Saving.name();
    }
}
