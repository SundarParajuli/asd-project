package framework.visitor;

import banking.CheckingAccount;
import banking.SavingAccount;
import creditcard.CreditAccount;
import framework.entity.Account;
import framework.entity.AccountDAO;
import framework.entity.InterestCalculationStrategy;

public class InterestCalculationVisitor implements AccountVisitor {
    AccountDAO accountDAO;


    public InterestCalculationVisitor(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    @Override
    public void visit(Account account) {
        account.interest();
        accountDAO.updateAccount(account);
    }
}
