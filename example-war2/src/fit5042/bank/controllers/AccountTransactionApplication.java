package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.TransactionManagedBean;
import fit5042.bank.mbeans.UserManagedBean;
import fit5042.bank.repository.entities.Users;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;

@Named(value = "accounttransactionApplication")
@ApplicationScoped
public class AccountTransactionApplication {
	
	@ManagedProperty(value = "#{transactionManagedBean}")
	TransactionManagedBean transactionManagedBean;
	
	private int accountId;
	
	private ArrayList<Transactions> transaction;
	

	public ArrayList<Transactions> getTransaction() {
		return transaction;
	}
	
	public ArrayList<Transactions> getTransactions(int accountId) {
		transaction.clear();
		updateTransactionList(accountId);
		return transaction;
	}

	public void setTransaction(ArrayList<Transactions> transaction) {
		this.transaction = transaction;
	}

	public AccountTransactionApplication() {
		transaction = new ArrayList<>();
		
		accountId = Integer
				.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("accountID"));
		
		// instantiate transactionManagedBean
				ELContext elContext = FacesContext.getCurrentInstance().getELContext();
				transactionManagedBean = (TransactionManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
						.getValue(elContext, null, "transactionManagedBean");
		
		// get users from db
		updateTransactionList(accountId);
	}

	private void updateTransactionList(int accountId) {
		if (transaction != null && transaction.size() > 0) {

		} else {
			transaction.clear();

			for (fit5042.bank.repository.entities.Transactions tran : transactionManagedBean.getAccountTransactions(accountId)) {
				transaction.add(tran);
			}

			setTransaction(transaction);
		}
		
	}

	/*public ArrayList<Transaction> getSelectedTransactions() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
}
