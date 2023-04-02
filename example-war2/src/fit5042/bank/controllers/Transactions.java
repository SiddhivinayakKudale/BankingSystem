package fit5042.bank.controllers;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;
import fit5042.bank.repository.entities.Account;

@RequestScoped
@Named(value = "transactions")
public class Transactions implements Serializable {
	private int transactionId;
	private String transactionName;
	private String transactionType;
	private double transactionAmount;
	private int fromAccount; //111
	private int toAccount;   //222
	
	private int accountId;
	private Account account;
	
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(int transactionId, String transactionName, String transactionType, double transactionAmount,
			int fromAccount, int toAccount,Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.account = account;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionName=" + transactionName
				+ ", transactionType=" + transactionType + ", transactionAmount=" + transactionAmount + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + "]";
	}
	
	public void myChangeEvent( AjaxBehaviorEvent e ) {
        System.out.println( "VALUE CHANGED" );
    }
	
}
