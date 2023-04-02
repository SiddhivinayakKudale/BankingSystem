package fit5042.bank.controllers;

	import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fit5042.bank.repository.UserRepository;

	@ManagedBean(name = "transactions", eager = true)
	@SessionScoped
	public class UserData implements Serializable {
		
		@EJB
		UserRepository userRepository;
		
	   private static final long serialVersionUID = 1L;
	   private int fromAccount;
	   

	   public int getFromAccount() {
		   return fromAccount;
	   }

	   public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	   }

	   public String showBalance() {
		 // fit5042.bank.repository.entities.Account account =  userRepository.getAccountBalance(name);
		//  return account.getAccountBalance();
	      return "Hello " + fromAccount;
	   }
	}

