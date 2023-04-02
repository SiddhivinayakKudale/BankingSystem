package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.mbeans.AccountManagedBean;

@Named(value = "accountApplication")
@RequestScoped
public class AccountApplication {

	@ManagedProperty(value = "#{accountManagedBean}")
	AccountManagedBean accountManagedBean;

	private ArrayList<Account> accounts; // arraylist to store all the values retrived from db
	private String userName;

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public AccountApplication() {
		accounts = new ArrayList<>();
		userName = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		//userName = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		accountManagedBean = (AccountManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "accountManagedBean");

		// get users from db
		updateUserList(userName);
	}

	private void updateUserList(String userName) {
		// TODO Auto-generated method stub
		if (accounts != null && accounts.size() > 0) {

		} else {
			accounts.clear();
			
			for (fit5042.bank.repository.entities.Account account : accountManagedBean.getAllAccounts(userName)) {
				accounts.add(account);
			}

			setAccounts(accounts);
		}

	}

}
