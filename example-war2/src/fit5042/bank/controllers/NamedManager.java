/*package fit5042.bank.controllers;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.AccountManagedBean;
import fit5042.bank.mbeans.UserAccountManagedBean;
import fit5042.bank.mbeans.UserManagedBean;

import java.io.Serializable;
import java.util.ArrayList;

@Named(value = "namedManager")
@ApplicationScoped
public class NamedManager implements Serializable {
	
	@ManagedProperty(value = "#{useraccountManagedBean}")
	UserAccountManagedBean useraccountManagedBean;
	
	private String username;
	
	private ArrayList<Account> accounts;
	
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public NamedManager() {
		accounts = new ArrayList<>();
		
		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		useraccountManagedBean = (UserAccountManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "useraccountManagedBean");

		// get users from db
		//updateAccountList();
	}

	private void updateAccountList() {
		
		// TODO Auto-generated method stub
		
	}

	public String loggedInUserName() {
		//username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		return "Sagar";
	}
	
	
	
}
*/