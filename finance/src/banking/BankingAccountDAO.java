package banking;


import framework.entity.Account;
import framework.entity.AccountDAO;

import java.util.*;

public class BankingAccountDAO implements AccountDAO {
    private static volatile BankingAccountDAO INSTANCE;
    Map<String, Account> accountDB = new HashMap<>();

    public static BankingAccountDAO getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (BankingAccountDAO.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BankingAccountDAO();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveAccount(Account account) {
        accountDB.put(account.getAccountNumber(), account);
        System.out.println("Saving account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        accountDB.put(account.getAccountNumber(), account);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return accountDB.get(accountNumber);
    }

    @Override
    public List<Account> getAccounts() {
        return new ArrayList<>(accountDB.values());
    }
}
