package creditcard;



import framework.entity.Account;
import framework.entity.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CreditAccountDAO implements AccountDAO {
    private static volatile CreditAccountDAO INSTANCE;
    Collection<Account> accountList = new ArrayList<>();
    private CreditAccountDAO(){

    }
    public static CreditAccountDAO getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (CreditAccountDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CreditAccountDAO();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveAccount(Account account) {
        accountList.add(account);
        System.out.println("Saving account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        Account oldAccount = loadAccount(account.getAccountNumber());
        if (oldAccount != null) {
            accountList.remove(oldAccount);
            accountList.add(account);
        }
        System.out.println("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountList) {
            if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                return account;
            }
        }

        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountList;
    }
}
