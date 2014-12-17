package com.tuenti.tuentitv.presenter;

import com.tuenti.tuentitv.model.Account;
import com.tuenti.tuentitv.model.Accounts;
import java.util.List;
import javax.inject.Inject;

/**
 * Class created to work as login view presenter. This presenter has all the responsibility related
 * to the login view presentation logic.
 *
 * Responsibilities:
 *
 * - Obtains a list of accounts previously logged and shows it. For this sample we are going to
 * mock
 * all this information with fake accounts.
 *
 * - If the user clicks on one account is going to show the password dialog. If the user enters his
 * password this presenter is going to start next view.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class LoginPresenter {

  private Accounts accounts;
  private View view;
  private List<Account> accountList;
  private Account selectedAccount;

  @Inject public LoginPresenter(Accounts accounts) {
    this.accounts = accounts;
  }

  public void setView(View view) {
    this.view = view;
  }

  public void loadAccounts() {
    accountList = accounts.getRecentLoggedAccounts();
    showAccounts(accountList);
  }

  public Account getAccountAtIndex(int position) {
    return accountList.get(position);
  }

  private void showAccounts(List<Account> accounts) {
    view.showAccounts(accounts);
  }

  public void onAccountClicked(Account selectedAccount) {
    this.selectedAccount = selectedAccount;
    view.showPasswordBox();
  }

  public interface View {

    void showAccounts(List<Account> accounts);

    void showPasswordBox();
  }
}