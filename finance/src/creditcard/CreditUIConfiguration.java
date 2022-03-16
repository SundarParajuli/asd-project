package creditcard;

import framework.entity.Account;
import framework.ui.UIConfiguration;

import java.util.Arrays;
import java.util.Collection;

public class CreditUIConfiguration implements UIConfiguration {
    @Override
    public Collection<String> getAccountTypes() {
        return Arrays.asList(CreditCardType.GOLD.name(), CreditCardType.SILVER.name(), CreditCardType.BRONZE.name());
    }

    @Override
    public Collection<String> getReportColumnNames() {
        return Arrays.asList("Name","CC number","Exp Date","Type","Balance");
    }

    @Override
    public int getIdColumnIndex() {
        return 1;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowData = new Object[5];
        rowData[0] = account.getCustomer().getName();
        rowData[1] = account.getAccountNumber();
		rowData[2] = "N/A";
		rowData[3] = account.getAccountType();
		rowData[4] = String.valueOf(account.getBalance());
        return rowData;
    }

    @Override
    public boolean hasReport() {
        return true;
    }
}
