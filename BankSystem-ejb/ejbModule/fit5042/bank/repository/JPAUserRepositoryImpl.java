package fit5042.bank.repository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;
import fit5042.bank.repository.entities.Users;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.DatatypeConverter;



@Stateless
public class JPAUserRepositoryImpl implements UserRepository {
	
	
	@PersistenceContext(unitName = "BankSystem-ejb")
	private EntityManager entityManager;

	@Override
	public void addUser(Users user) throws Exception {
		String text = user.getPassword();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		String encoded = DatatypeConverter.printHexBinary(hash);   
		//List<Users> users = entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
		//user.setUserId(users.get(0).getUserId() + 1);
		
		user.setPassword(encoded);
	    entityManager.persist(user);
	}

	@Override
	public List<Users> getAllProperties() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Users.class);
        List<Users> lp = entityManager.createQuery(query).getResultList();
        return lp;
		//return entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList();
	}

	@Override
	public void removeProperty(int userId) {
		Users user = entityManager.find(Users.class, userId);
        if (user != null) {
            entityManager.remove(user);
        }
		
	}

	@Override
	public List<Account> getAllAccounts(String userName) {
		List<Users> user = searchByUserName(userName);
		int userId = user.get(0).getUserId();
		//Account acc = entityManager.find(Account.class, userName);
		Users u = new Users();
		u.setUserId(userId);
		return entityManager.createNamedQuery(Account.GET_ALL_QUERY_NAME).setParameter("users", u).getResultList();
	}

	private List<Users> searchByUserName(String userName) {
		return entityManager.createNamedQuery(Users.GET_USERID_QUERY_NAME).setParameter("username", userName).getResultList();	
	}

	@Override
	public void editUser(Users user) {
		 try {
	            entityManager.merge(user);
	        } catch (Exception ex) {

	        }
	}

	@Override
	public void addTransaction(Transactions transaction) {
		Account acc = entityManager.find(Account.class, transaction.getFromAccount());
		int fromAccount = transaction.getFromAccount();
		int toAccount = transaction.getToAccount();
		double transactionAmount = transaction.getTransactionAmount();
		entityManager.createNamedQuery(Account.UPDATE_QUERY_NAME).setParameter("accountNo", fromAccount).
		setParameter("transactionAmount", transactionAmount).executeUpdate();
		entityManager.createNamedQuery(Account.UPDATE_QUERY_NAME2).setParameter("accountNo", toAccount).
		setParameter("transactionAmount", transactionAmount).executeUpdate();
		try {
			transaction.setAccount(acc);
			entityManager.persist(transaction);
		} catch (Exception e) {		
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Transactions> getTransactions() {
		return entityManager.createNamedQuery(Transactions.GET_ALL_QUERY_NAME).getResultList();
		//return entityManager.createNamedQuery("SELECT u FROM Transactions u").getResultList();
	}

	@Override
	public List<Transactions> getAccountTransactions(int accountId) {
		//int id = 1;
		Account account = entityManager.find(Account.class, accountId);
		int accountNo = account.getAccountNo();
		return entityManager.createNamedQuery(Transactions.GET_QUERY_NAME).setParameter("accountID", accountNo).getResultList();
	}

	

	@Override
	public Transactions searchTransactionById(int transactionId) {
		Transactions transaction = entityManager.find(Transactions.class, transactionId);
        return transaction;
	}

	@Override
	public Users searchUserById(int userId) {
		Users user = entityManager.find(Users.class, userId);
        return user;
	}

	@Override
	public List<Transactions> searchTransactionByType(String transactionType) {
		return entityManager.createNamedQuery(Transactions.GET_ALL_QUERY_NAME2).
				setParameter("transactionType", transactionType).
				getResultList();
		
	}

	@Override
	public List<Account> getAccounts() {
		return entityManager.createNamedQuery(Account.GET_ALLACCOUNTS_QUERY_NAME).getResultList();
	}

	@Override
	public Account getAccountBalance(int accountId) {
		Account account = entityManager.find(Account.class, accountId);
        return account;
	}

	@Override
	public List<Transactions> searchTransactionByIdAndType(int transactionId, String transactionType) {
		return entityManager.createNamedQuery(Transactions.GET_ALLBYIDANDTYPE_QUERY_NAME).
				setParameter("transactionType", transactionType).setParameter("transactionId", transactionId).
				getResultList();
	}

	@Override
	public void addNewAccount(Account account, String loggedInUserName) {
		List<Users> user = searchByUserName(loggedInUserName);
		int userId = user.get(0).getUserId();
		Users usr = entityManager.find(Users.class, userId);
		account.setUser(usr);
		entityManager.persist(account);
		
	}
}
