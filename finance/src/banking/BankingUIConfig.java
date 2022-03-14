package banking;

import framework.Account;
import framework.Personal;
import framework.ui.UIConfig;

import java.util.Arrays;
import java.util.Collection;

public class BankingUIConfig implements UIConfig {
    @Override
    public Collection<String> getAccountTypes() {
        return Arrays.asList(AccountTypes.Checking.name(), AccountTypes.Saving.name());
    }

    @Override
    public Collection<String> getReportColumnNames() {
        return Arrays.asList("AccountNr","Name","City","P/C","Ch/S","Amount");
    }

    @Override
    public int getIdColumnIndex() {
        return 0;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowdata = new Object[6];
        rowdata[0] = account.getAccountNumber();
		rowdata[1] = account.getCustomer().getName();
		rowdata[2] = account.getCustomer().getCity();
		rowdata[3] = account.getCustomer() instanceof Personal ? "P" : "C";
		rowdata[4] = account.getAccountType();
		rowdata[5] = String.valueOf(account.getBalance());
        return rowdata;
    }

    @Override
    public boolean hasReport() {
        return false;
    }
}
