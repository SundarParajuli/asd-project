package creditcard;



import framework.entity.Account;
import framework.entity.AccountDAO;

import java.util.*;

public class CreditAccountDAO implements AccountDAO {
    private static volatile CreditAccountDAO INSTANCE;
    Map<String, Account> accountDB = new HashMap<>();
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
        accountDB.put(account.getAccountNumber(), account);
        System.out.println("Account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        accountDB.put(account.getAccountNumber(), account);
        System.out.println("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
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
