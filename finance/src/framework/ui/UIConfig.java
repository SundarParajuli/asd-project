package framework.ui;

import framework.entity.Account;

import java.util.Collection;

public interface UIConfig {
    Collection<String> getAccountTypes();
    Collection<String> getReportColumnNames();
    int getIdColumnIndex();
    Object[] buildRow(Account account);
    boolean hasReport();
}
