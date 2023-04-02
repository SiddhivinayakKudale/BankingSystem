package fit5042.bank.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "account")
public class Account implements Serializable {
	private int accountNo;
	private double accountBalance;
	private String accounttype;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int accountNo, double accountBalance, String accounttype) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accounttype = accounttype;
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getAccounttype() {
		return accounttype;
	}
	
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBalance=" + accountBalance + ", accounttype=" + accounttype
				+ "]";
	}
}
