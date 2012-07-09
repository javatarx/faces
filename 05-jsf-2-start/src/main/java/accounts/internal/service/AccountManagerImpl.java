package accounts.internal.service;

import java.util.List;
import java.util.Map;

import accounts.Account;
import accounts.internal.dao.AccountRepository;

import common.money.Percentage;

public class AccountManagerImpl implements AccountManager {
	
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		
		return accountRepository.getAllAccounts();
	}

	@Override
	public Account getAccount(Long id) {
		
		return accountRepository.getAccount(id);
	}

	@Override
	public void update(Account account) {
		
		accountRepository.update(account);
	}

	@Override
	public void updateBeneficiaryAllocationPercentages(Long accountId,
			Map<String, Percentage> allocationPercentages) {
		
		accountRepository.updateBeneficiaryAllocationPercentages(accountId, allocationPercentages);
	}

	@Override
	public void addBeneficiary(Long accountId, String beneficiaryName) {
		
		accountRepository.addBeneficiary(accountId, beneficiaryName);
	}

	@Override
	public void removeBeneficiary(Long accountId, String beneficiaryName,
			Map<String, Percentage> allocationPercentages) {
		
		accountRepository.removeBeneficiary(accountId, beneficiaryName, allocationPercentages);
	}

	@Override
	public Account findAccount(String number) {
		
		return accountRepository.findAccount(number);
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

}