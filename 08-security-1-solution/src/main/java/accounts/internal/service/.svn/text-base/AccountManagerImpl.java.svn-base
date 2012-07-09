package accounts.internal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accounts.Account;
import accounts.internal.dao.AccountRepository;

import common.money.Percentage;

@Service("accountManager")
public class AccountManagerImpl implements AccountManager {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public List<Account> getAllAccounts() {
		
		return accountRepository.getAllAccounts();
	}

	public Account getAccount(Long id) {
		
		return accountRepository.getAccount(id);
	}
	
	public void update(Account account) {
		
		accountRepository.update(account);
	}
	
	public void updateBeneficiaryAllocationPercentages(Long accountId,
			Map<String, Percentage> allocationPercentages) {
		
		accountRepository.updateBeneficiaryAllocationPercentages(accountId, allocationPercentages);
	}
	
	public void addBeneficiary(Long accountId, String beneficiaryName) {
		
		accountRepository.addBeneficiary(accountId, beneficiaryName);
	}

	public void removeBeneficiary(Long accountId, String beneficiaryName,
			Map<String, Percentage> allocationPercentages) {
		
		accountRepository.removeBeneficiary(accountId, beneficiaryName, allocationPercentages);
	}
	
	public Account findAccount(String number) {
		
		return accountRepository.findAccount(number);
	}

	public void delete(Long id) {
		this.accountRepository.delete(id);		
	}

}