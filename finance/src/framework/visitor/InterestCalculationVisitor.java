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
    public void visit(CheckingAccount account) {
        account.addInterest();
        accountDAO.updateAccount(account);
    }

    @Override
    public void visit(SavingAccount account) {
        account.addInterest();
        accountDAO.updateAccount(account);
    }

    @Override
    public void visit(CreditAccount account) {
        account.addInterest();
        accountDAO.updateAccount(account);
    }
}
