package banking;

import framework.entity.Account;
import framework.entity.Personal;
import framework.ui.UIConfiguration;

import java.util.Arrays;
import java.util.Collection;

public class BankingUIConfiguration implements UIConfiguration {
    @Override
    public Collection<String> getAccountTypes() {
        return Arrays.asList(AccountType.CHECKING.name(), AccountType.SAVING.name());
    }

    @Override
    public Collection<String> getReportColumnNames() {
        return Arrays.asList("AccountNr","Name","City","Personal/Company","Checking/Saving","Amount");
    }

    @Override
    public int getIdColumnIndex() {
        return 0;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowData = new Object[6];
        rowData[0] = account.getAccountNumber();
		rowData[1] = account.getCustomer().getName();
		rowData[2] = account.getCustomer().getCity();
		rowData[3] = account.getCustomer() instanceof Personal ? "Personal" : "Company";
		rowData[4] = account.getAccountType();
		rowData[5] = String.valueOf(account.getBalance());
        return rowData;
    }

    @Override
    public boolean hasReport() {
        return false;
    }
}
