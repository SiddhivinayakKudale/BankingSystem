package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.AccountManagedBean;
import fit5042.bank.mbeans.TransactionManagedBean;
import fit5042.bank.mbeans.UserManagedBean;

@RequestScoped
@Named("addAccount")
public class AddAccount {
	
	@ManagedProperty(value = "#{accountManagedBean}")
	AccountManagedBean accountManagedBean;
	
	AccountApplication app;
	
	private String userName;
	
	public AddAccount() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (AccountApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "accountApplication");
		
		userName = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		accountManagedBean = (AccountManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "accountManagedBean");
	}
	
	// Code for adding the transaction
		public void addAccount(Account localAccount) {
			// this is the local property, not the entity
			try {
				// add this property to db via EJB
				accountManagedBean.addAccount(localAccount,userName);

				// refresh the list in PropertyApplication bean
				//app.searchAll();

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("transaction has been added succesfully"));
			} catch (Exception ex) {

			}
		}

}
