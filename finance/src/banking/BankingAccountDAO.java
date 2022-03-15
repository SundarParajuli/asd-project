package banking;


import framework.entity.Account;
import framework.entity.AccountDAO;

import java.util.ArrayList;
import java.util.Collection;

public class BankingAccountDAO implements AccountDAO {
    private static volatile BankingAccountDAO instance;
    Collection<Account> accountlist = new ArrayList<>();

    public static BankingAccountDAO getInstance() {
        if (instance == null) {
            synchronized (BankingAccountDAO.class) {
                if (instance == null) {
                    instance = new BankingAccountDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account);
        System.out.println("Saving account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
        System.out.println("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
