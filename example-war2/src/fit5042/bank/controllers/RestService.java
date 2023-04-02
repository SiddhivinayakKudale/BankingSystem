package fit5042.bank.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import fit5042.bank.mbeans.UserManagedBean;
import fit5042.bank.repository.UserRepository;
import fit5042.bank.repository.entities.Account;
import fit5042.bank.repository.entities.Transactions;
import fit5042.bank.repository.entities.Users;

@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

	@EJB
	UserRepository userRepository;
	
	@GET
	@Path("/object")
	@Produces(MediaType.APPLICATION_JSON)
	public Users getObject() {
		try {
			List<Users> t = userRepository.getAllProperties();
			Users tt = t.get(0);
			return tt;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	} 
	
	
	@GET
	@Path("/getAcc")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> getObjectAcc() {
		try {
			List<Account> t = userRepository.getAccounts();
			Account tt = t.get(2);
			return t;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	} 
	
	/*@GET
	@Path("/object")
	@Produces(MediaType.APPLICATION_JSON)
	public Transactions getTransactions() {
		try {
			List<Transactions> t = userRepository.getTransactions();
			Transactions tt = t.get(0);
			return tt;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}*/
}
