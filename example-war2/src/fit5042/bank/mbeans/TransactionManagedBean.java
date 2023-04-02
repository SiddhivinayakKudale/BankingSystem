package fit5042.bank.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import fit5042.bank.repository.UserRepository;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;
import fit5042.bank.repository.entities.Users;


@ManagedBean(name = "transactionManagedBean")
@SessionScoped
public class TransactionManagedBean implements Serializable {

	@EJB
	UserRepository userRepository;

	private String username;

	public TransactionManagedBean() {
		//username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
	}

	public void addTransaction(fit5042.bank.controllers.Transactions localtransaction) {
		// convert this newProperty which is the local property to entity property
		Transactions transaction = convertTransactionToEntity(localtransaction);

		try {
			userRepository.addTransaction(transaction);
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

	private Transactions convertTransactionToEntity(fit5042.bank.controllers.Transactions localtransaction) {
		// TODO Auto-generated method stub
		Transactions transaction = new Transactions();
		String name = localtransaction.getTransactionName();
		String type = localtransaction.getTransactionType();
		double amount = localtransaction.getTransactionAmount();
		int toAccount = localtransaction.getToAccount();
		int fromAccount = localtransaction.getFromAccount();
		
		//Account acc = new Account(111,100.0,"savings");
		//transaction.setAccount(acc);
		transaction.setTransactionName(name);
		transaction.setTransactionType(type);
		transaction.setTransactionAmount(amount);
		transaction.setToAccount(toAccount);
		transaction.setFromAccount(fromAccount);
		return transaction;
	}
	
	
	/*public Transactions call() {
		
		Client client = ClientBuilder.newClient();
		Transactions obj =  client.target("http://localhost:8080/example-war2/resources/MyRestService/object").request().get(Transactions.class);
		//ArrayList<Users> obj =  client.target("http://localhost:8080/example-war2/resources/MyRestService/object").request().get(new GenericType<List<Employee>>(){}));
		return obj;
	}*/

	public List<Transactions> getTransactions() {
		try {
			List<Transactions> t = userRepository.getTransactions();
			return t;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public List<Transactions> getAccountTransactions(int accountId) {
		try {
			List<Transactions> t = userRepository.getAccountTransactions(accountId);
			return t;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public Transactions searchTransactionById(int transactionId) {
		try {
            return userRepository.searchTransactionById(transactionId);
        } catch (Exception ex) {
            Logger.getLogger(TransactionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
	}

	public List<Transactions> searchTransactionByType(String transactionType) {
		try {
            return userRepository.searchTransactionByType(transactionType);
        } catch (Exception ex) {
            Logger.getLogger(TransactionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
	}

	public List<Transactions> searchTransactionByIdAndType(int transactionId, String transactionType) {
		try {
            return userRepository.searchTransactionByIdAndType(transactionId,transactionType);
        } catch (Exception ex) {
            Logger.getLogger(TransactionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
	}

	/*public String loggedInUserName() {
		return username;
	}*/

	
}
