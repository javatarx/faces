package accounts.web;

import java.util.List;

import accounts.Account;
import accounts.internal.service.AccountManager;

public class AccountController extends BasePage {

	private String id;
	private AccountManager accountManager;
	private List<Account> accounts;
	private Account account = new Account();

	public List<Account> getAccounts() {
		accounts = accountManager.getAllAccounts();
		return accounts;
	}
	
	public String accountDetails(){
		id = getParameter("id");
		account = accountManager.getAccount(new Long(id));
		return "accountDetails";
	}	
		
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}