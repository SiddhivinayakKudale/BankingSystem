package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.TransactionManagedBean;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;
import fit5042.bank.repository.entities.Users;

@Named(value = "transactionController")
@RequestScoped
public class TransactionController {
	
	private int accountId; // this propertyId is the index, don't confuse with the Property Id

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	private ArrayList<Transactions> transaction;
	
	public ArrayList<Transactions> getTransaction() {
		return transaction;
	}

	public void setTransaction(ArrayList<Transactions> transaction) {
		this.transaction = transaction;
	}

	public TransactionController() {
		accountId = Integer
				.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("accountID"));
		
		
		transaction = getAccountTransactions(accountId);
		//updateTransactionList(accountId);
	}

	private ArrayList<Transactions> getAccountTransactions(int accountId) {
		if (transaction == null) {
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			AccountTransactionApplication app = (AccountTransactionApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
					.getValue(context, null, "accounttransactionApplication");
			// -1 to propertyId since we +1 in JSF (to always have positive property id!)
			return app.getTransactions(accountId); // this propertyId is the index, don't confuse with the Property Id
		}
		return null;
	}

	/*public ArrayList<Transaction> getTransactions(int accountId) {
		if (trans == null) {
			// Get application context bean PropertyApplication
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			TransactionApplication app = (TransactionApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
					.getValue(context, null, "transactionApplication");
			// -1 to propertyId since we +1 in JSF (to always have positive property id!)
			return app.getSelectedTransactions().get(--accountId); // this propertyId is the index, don't confuse with the Property Id
		}
		return trans;
	}*/
	
	/*private void updateTransactionList(int accountId) {
		if (transaction != null && transaction.size() > 0) {

		} else {
			transaction.clear();

			for (fit5042.bank.repository.entities.Transactions tran : transactionManagedBean.getTransactions(accountId)) {
				transaction.add(tran);
			}

			setTransaction(transaction);
		}
		
	}*/

}
