package framework.visitor;

import banking.CheckingAccount;
import banking.SavingAccount;
import creditcard.CreditAccount;
import framework.entity.Account;
import framework.entity.Customer;

import java.time.LocalDate;

public class ReportBuilderVisitor implements AccountVisitor{
    private StringBuilder sb;

    public ReportBuilderVisitor(String type){
        sb = new StringBuilder();
        sb.append("\tReport for " + type + "\tdate : " + LocalDate.now());
        sb.append("\n-----------------------------------------------------\n\n");
    }


    @Override
    public void visit(CheckingAccount account) {
        bankingAccountVisit(account);
    }

    @Override
    public void visit(SavingAccount account) {

        bankingAccountVisit(account);
    }

    private void bankingAccountVisit(Account account) {
        Customer customer = account.getCustomer();
        double balance = account.getBalance();
        sb.append(String.format("Name= %s\r\n", customer.getName()));
        sb.append(String.format("Address= %s, %s, %s, %s\r\n", customer.getStreet(), customer.getCity(), customer.getState(), customer.getZip()));
        sb.append(String.format("Account number= %s\r\n", account.getAccountNumber()));
        sb.append(String.format("Account type= %s\r\n", account.getAccountType()));
        sb.append(String.format("Previous balance = $ %f\r\n", balance));
        sb.append("\r\n");
        sb.append("\r\n");
    }

    @Override
    public void visit(CreditAccount account) {
        Customer customer = account.getCustomer();
        CreditAccount creditAccount = (CreditAccount) account;
        double prevBalance = creditAccount.getPrevBalance();
        double totalCredit = creditAccount.getTotalCredit();
        double totalCharge = creditAccount.getTotalCharge();
        double newBalance = creditAccount.getNewBalance();
        double totalDue = creditAccount.getTotalDue();
        sb.append(String.format("Name= %s\r\n", customer.getName()));
        sb.append(String.format("Address= %s, %s, %s, %s\r\n", customer.getStreet(), customer.getCity(), customer.getState(), customer.getZip()));
        sb.append(String.format("CC number= %s\r\n", account.getAccountNumber()));
        sb.append(String.format("CC type= %s\r\n", account.getAccountType()));
        sb.append(String.format("Previous balance = $ %f\r\n", prevBalance));
        sb.append(String.format("Total Credits = $ %f\r\n", totalCredit));
        sb.append(String.format("Total Charges = $ %f\r\n", totalCharge));
        sb.append(String.format("New balance = $ %f\r\n", newBalance));
        sb.append(String.format("Total amount due = $ %f\r\n", totalDue));
        sb.append("\r\n");
        sb.append("\r\n");
    }

    public String getReport(){
        return sb.toString();
    }
}
