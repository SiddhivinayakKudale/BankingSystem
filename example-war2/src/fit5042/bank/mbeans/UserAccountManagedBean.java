/*package fit5042.bank.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.bank.repository.UserRepository;
import fit5042.bank.repository.entities.Account;

@ManagedBean(name = "useraccountManagedBean")
@SessionScoped
public class UserAccountManagedBean implements Serializable {

	@EJB
	UserRepository userRepository;
	
	private String usern;

	public UserAccountManagedBean() {
		usern = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
	}
	
	public String getUser() {
		return usern;
	}

	public List<Account> getAllAccounts() {
		try {

			List<Account> account = userRepository.getAllAccounts();
			return account;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
*/