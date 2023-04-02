package fit5042.bank.repository.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({
    @NamedQuery(name = Transactions.GET_ALL_QUERY_NAME, query = "SELECT u FROM Transactions u"),
    @NamedQuery(name = Transactions.GET_QUERY_NAME, query = "SELECT u FROM Transactions u WHERE u.fromAccount = :accountID"),
    @NamedQuery(name = Transactions.GET_QUERY_NAME1, query = "SELECT u FROM Transactions u WHERE u.transactionId = " + 1),
    @NamedQuery(name = Transactions.GET_ALL_QUERY_NAME2, query = "SELECT u FROM Transactions u WHERE u.transactionType LIKE :transactionType"),
    @NamedQuery(name = Transactions.GET_ALLBYIDANDTYPE_QUERY_NAME, query = "SELECT u FROM Transactions u WHERE u.transactionType = :transactionType and u.toAccount = :transactionId")
})
@Table(name = "transactions")
public class Transactions implements Serializable {
	
	public static final String GET_ALL_QUERY_NAME = "Transactions.getAll";
	public static final String GET_QUERY_NAME = "Transactions.getByAccount";
	public static final String GET_QUERY_NAME1 = "Transactions.getByAccounts";
	public static final String GET_ALL_QUERY_NAME2 = "Transactions.getByTransactionType";
	public static final String GET_ALLBYIDANDTYPE_QUERY_NAME = "Transactions.getByTransactionIDAndType";
	
	private int transactionId;
	
	@NotNull(message= "Transaction Name cannot be null")
	@Size(min=1, max=16)
	private String transactionName;
	
	@NotNull(message= "TransactionType cannot be null")
	@Size(min=1, max=16)
	private String transactionType;
	
	@NotNull(message= "Transaction Amount cannot be null")
	private double transactionAmount;
	
	@NotNull(message= "From Account cannot be null")
	private int fromAccount;
	
	@NotNull(message= "To Account cannot be null")
	private int toAccount;   
	
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
	
	@ManyToOne
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "transaction_id")
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
	
	
}
