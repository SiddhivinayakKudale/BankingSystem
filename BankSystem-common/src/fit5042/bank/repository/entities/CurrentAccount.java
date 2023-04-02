package fit5042.bank.repository.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "current_account_table_per_class")
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name = "accountNo")
public class CurrentAccount extends Account {
	private String averageBalance;

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(int accountNo, double accountBalance, String accounttype,String averageBalance) {
		super(accountNo, accountBalance, accounttype);
		this.averageBalance = averageBalance;
		// TODO Auto-generated constructor stub
	}

	public String getAverageBalance() {
		return averageBalance;
	}

	public void setAverageBalance(String averageBalance) {
		this.averageBalance = averageBalance;
	}
}
