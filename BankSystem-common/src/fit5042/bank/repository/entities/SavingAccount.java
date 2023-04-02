package fit5042.bank.repository.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "savings_account_table_per_class")
@DiscriminatorValue(value = "S")
@PrimaryKeyJoinColumn(name = "accountNo")
public class SavingAccount extends Account {
	private String interestRate;
	private String benefits;
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavingAccount(int accountNo, double accountBalance, String accounttype,String interestRate,String benefits) 
	{
		super(accountNo, accountBalance, accounttype);
		// TODO Auto-generated constructor stub
		this.interestRate = interestRate;
		this.benefits = benefits;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	
	
}
