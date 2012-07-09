package accounts.web;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import accounts.Account;
import accounts.internal.service.AccountManager;

@Component("accountList")
@Scope("session")
public class AccountList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1227637581783372307L;
	
	@Autowired
	private AccountManager accountManager;

	public List<Account> getAccounts() {
		List<Account> accounts = accountManager.getAllAccounts();
		return accounts;
	}
}