package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;





@RequestScoped
@Named("searchTransaction")
public class SearchTransaction {
	private boolean showForm = true;
	
	private Transactions transaction;
	
	TransactionApplication app;
	
	private int searchByInt;
	
	private String searchByString;
	
	private int searchByInt1;
	
	private String searchByString1;
	
	
	
	

	public int getSearchByInt1() {
		return searchByInt1;
	}

	public void setSearchByInt1(int searchByInt1) {
		this.searchByInt1 = searchByInt1;
	}

	public String getSearchByString1() {
		return searchByString1;
	}

	public void setSearchByString1(String searchByString1) {
		this.searchByString1 = searchByString1;
	}

	public String getSearchByString() {
		return searchByString;
	}

	public void setSearchByString(String searchByString) {
		this.searchByString = searchByString;
	}

	public SearchTransaction() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		app = (TransactionApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null, "transactionApplication");

		app.updateTransactionList();
	}
	
	public void searchTransactionById(int transactionId) {
        try {
            //search this property then refresh the list in PropertyApplication bean
            app.searchTransactionById(transactionId);
        } catch (Exception ex) {

        }
        showForm = true;

    }
	
	public void searchAll() {
		app.searchAll();
	}
	
	
	
	public void searchTransactionByType(String transactionType) {
        try {
            //search this property then refresh the list in PropertyApplication bean
            app.searchTransactionByType(transactionType);
        } catch (Exception ex) {

        }
        showForm = true;

    }
	
	public void searchTransactionByIdString(int transactionId,String transactionType) {
        try {
        	app.searchTransactionByIdAndType(transactionId,transactionType);
        } catch (Exception ex) {

        }
        showForm = true;

    }
	
	

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Transactions getTransaction() {
		return transaction;
	}

	public void setTransaction(Transactions transaction) {
		this.transaction = transaction;
	}

	public TransactionApplication getApp() {
		return app;
	}

	public void setApp(TransactionApplication app) {
		this.app = app;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}
	
	
}
