package accounts.web;

import java.util.List;

import org.apache.commons.lang.StringUtils;

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
		if(id!=null){
			account = accountManager.getAccount(new Long(id));
		}
		return "accountDetails";
	}
	public String updateAccount(){
		if(account.getEntityId() == null || 
			StringUtils.isBlank(account.getEntityId().toString()) ||
			account.getEntityId().toString().equalsIgnoreCase("0")){
			account.setEntityId(null);
		}
		accountManager.update(account);
		return "accountSummary";
	}

	public String deleteAccount(){
		accountManager.delete(account.getEntityId());
		return "accountSummary";
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