package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.TransactionManagedBean;
import fit5042.bank.mbeans.UserManagedBean;

@RequestScoped
@Named("addTransaction")
public class AddTransaction {
	
	@ManagedProperty(value = "#{transactionManagedBean}")
	TransactionManagedBean transactionManagedBean;
	
	TransactionApplication app;
	
	public AddTransaction() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (TransactionApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "transactionApplication");

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		transactionManagedBean = (TransactionManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "transactionManagedBean");
	}
	
	// Code for adding the transaction
		public void addTransaction(Transactions localtransaction) {
			// this is the local property, not the entity
			try {
				// add this property to db via EJB
				transactionManagedBean.addTransaction(localtransaction);

				// refresh the list in PropertyApplication bean
				//app.searchAll();

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("transaction has been added succesfully"));
			} catch (Exception ex) {

			}
		}

}
