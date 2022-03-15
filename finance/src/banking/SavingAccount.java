package banking;


import framework.entity.Account;
import framework.entity.InterestCalculator;
import framework.visitor.AccountVisitor;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculator interestCalculator) {
        super(interestCalculator);
    }

    @Override
    public String getAccountType() {
        return AccountTypes.Saving.name();
    }

    @Override
    public void accept(AccountVisitor accountVisitor) {
        accountVisitor.visit(this);
    }
}
