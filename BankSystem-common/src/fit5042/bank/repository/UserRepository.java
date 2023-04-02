package fit5042.bank.repository;

import java.util.List;

import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;
import fit5042.bank.repository.entities.Users;

public interface UserRepository {
	
	public void addUser(Users user) throws Exception;

	public List<Users> getAllProperties();

	public void removeProperty(int userId);

	public List<Account> getAllAccounts(String userName);

	public void editUser(Users user);

	public void addTransaction(Transactions transaction);

	public List<Transactions> getTransactions();

	public List<Transactions> getAccountTransactions(int accountId);

	public Transactions searchTransactionById(int transactionId);

	public Users searchUserById(int userId);

	public List<Transactions> searchTransactionByType(String transactionType);

	public List<Account> getAccounts();

	public Account getAccountBalance(int name);

	public List<Transactions> searchTransactionByIdAndType(int transactionId, String transactionType);

	public void addNewAccount(Account account, String loggedInUserName);
	
}
