package accounts.internal.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import accounts.Account;

import common.money.Percentage;

/**
 * An account manager that uses Hibernate to find accounts.
 */
@Repository("accountRepository")
public class HibernateAccountRepository extends HibernateDaoSupport  
		implements AccountRepository {

	@Autowired
	public HibernateAccountRepository(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@Transactional(readOnly = true)
	public Account findAccount(String number) {
		return (Account) getSession().
			createQuery("from Account a where a.number = ?").
			setString(0, number).uniqueResult();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {
		return getHibernateTemplate().find("from Account");
	}

	@Transactional(readOnly = true)
	public Account getAccount(Long id) {
		return (Account) getHibernateTemplate().get(Account.class, id);
	}

	@Transactional
	public void update(Account account) {
		getHibernateTemplate().saveOrUpdate(account);
	}

	@Transactional
	public void updateBeneficiaryAllocationPercentages(Long accountId, Map<String, Percentage> allocationPercentages) {
		Account account = getAccount(accountId);
		for (Entry<String, Percentage> entry : allocationPercentages.entrySet()) {
			account.getBeneficiary(entry.getKey()).setAllocationPercentage(entry.getValue());
		}
	}

	@Transactional
	public void addBeneficiary(Long accountId, String beneficiaryName) {
		getAccount(accountId).addBeneficiary(beneficiaryName, Percentage.zero());
	}

	@Transactional
	public void removeBeneficiary(Long accountId, String beneficiaryName, Map<String, Percentage> allocationPercentages) {
		getAccount(accountId).removeBeneficiary(beneficiaryName);
		updateBeneficiaryAllocationPercentages(accountId, allocationPercentages);
	}

	@PreAuthorize("hasRole('ROLE_CUSTOMER')")
	public void delete(Long id) {
		getHibernateTemplate().delete(getAccount(id));		
	}
}