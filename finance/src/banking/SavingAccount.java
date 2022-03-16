package banking;


import framework.entity.Account;
import framework.entity.InterestCalculationStrategy;
import framework.visitor.AccountVisitor;

public class SavingAccount extends Account {
    public SavingAccount(InterestCalculationStrategy interestCalculationStrategy) {
        super(interestCalculationStrategy);
    }

    @Override
    public String getAccountType() {
        return AccountType.SAVING.name();
    }

    @Override
    public void accept(AccountVisitor accountVisitor) {
        accountVisitor.visit(this);
    }
}
