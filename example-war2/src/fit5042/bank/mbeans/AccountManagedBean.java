package fit5042.bank.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.bank.repository.UserRepository;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;

@ManagedBean(name = "accountManagedBean")
@SessionScoped
public class AccountManagedBean implements Serializable {

	@EJB
	UserRepository userRepository;

	private String userName;

	public AccountManagedBean() {
		//userName = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
	}

	
	 public String loggedInUserName() {
		return "sagar";
	}

	public List<Account> getAllAccounts(String userName) {
		try {
			List<Account> account = userRepository.getAllAccounts(userName);
			return account;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	
	public List<Account> getAllAcounts() {
		try {
			List<Account> account = userRepository.getAccounts();
			return account;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}


	public void addAccount(fit5042.bank.controllers.Account localAccount, String loggedInUserName) {
		Account account = convertAccountToEntity(localAccount);
		try {
			userRepository.addNewAccount(account,loggedInUserName);
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	private Account convertAccountToEntity(fit5042.bank.controllers.Account localAccount) {
		Account account = new Account();
		String accountType = localAccount.getAccounttype();
		double balance = localAccount.getAccountBalance();
		account.setAccounttype(accountType);
		account.setAccountBalance(balance);
		return account;
	}
}
