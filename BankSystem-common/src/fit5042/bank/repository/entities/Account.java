package fit5042.bank.repository.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "accounttype",
					discriminatorType = DiscriminatorType.STRING,
					length = 1)
@Entity
@NamedQueries({
    @NamedQuery(name = Account.GET_ALL_QUERY_NAME, query = "SELECT u FROM Account u where u.user= :users" ),
    @NamedQuery(name = Account.UPDATE_QUERY_NAME, query = "UPDATE Account u SET u.accountBalance = u.accountBalance - :transactionAmount  where u.accountNo= :accountNo"),
    @NamedQuery(name = Account.UPDATE_QUERY_NAME2, query = "UPDATE Account u SET u.accountBalance = u.accountBalance + :transactionAmount  where u.accountNo= :accountNo"),
    @NamedQuery(name = Account.GET_ALLACCOUNTS_QUERY_NAME, query = "SELECT u FROM Account u")
    })
@Table(name = "account")
public class Account implements Serializable {
	
	public static final String GET_ALL_QUERY_NAME = "Account.getAll";


	public static final String UPDATE_QUERY_NAME = "Account.updateAccountBalance";


	public static final String UPDATE_QUERY_NAME2 = "Account.updateToAccountBalance";


	public static final String GET_ALLACCOUNTS_QUERY_NAME = "Account.getAllAccounts";
	
	
	//private int accountId;
	private int accountNo;
	
	@NotNull(message= "Account Balance cannot be null")
	private double accountBalance;
	
	@NotNull(message= "Account Type cannot be null")
	private String accounttype;
	
	//@Column(name = "user_user_id")
	private Users user;
	
	private Set<Transactions> transactions;
	
	public Account() {
		super();
		this.transactions = new HashSet<>();
	}
	
	public Account(int accountNo, double accountBalance, String accounttype) {
		super();
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.accounttype = accounttype;
		this.transactions = new HashSet<>();
	}
	
	
	@ManyToOne
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="account")
	public Set<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transactions> transactions) {
		this.transactions = transactions;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "account_no")
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
