package accounts.internal.dao;

import java.util.List;
import java.util.Map;

import accounts.Account;

import common.money.Percentage;


public interface AccountRepository {

	public List<Account> getAllAccounts();
	public Account getAccount(Long id);
	public void update(Account account);
	public void updateBeneficiaryAllocationPercentages(Long accountId, Map<String, Percentage> allocationPercentages);
	public void addBeneficiary(Long accountId, String beneficiaryName);
	public void removeBeneficiary(Long accountId, String beneficiaryName, Map<String, Percentage> allocationPercentages);
	public Account findAccount(String number);
}
