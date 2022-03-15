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
        Object[] rowdata = new Object[5];
        rowdata[0] = account.getCustomer().getName();
        rowdata[1] = account.getAccountNumber();
		rowdata[2] = "N/A";
		rowdata[3] = account.getAccountType();
		rowdata[4] = String.valueOf(account.getBalance());
        return rowdata;
    }

    @Override
    public boolean hasReport() {
        return true;
    }
}
