package fit5042.bank.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.bank.repository.UserRepository;
import fit5042.bank.repository.entities.Users;

@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

	@EJB
	UserRepository userRepository;

	public UserManagedBean() {

	}

	public void addUser(Users user) {
		try {
			userRepository.addUser(user);
		} catch (Exception e) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	// adding the user
	public void addUser(fit5042.bank.controllers.Users localUser) {
		// convert this newProperty which is the local property to entity property
		Users user = convertUserToEntity(localUser);

		try {
			userRepository.addUser(user);
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// adding the user
	private Users convertUserToEntity(fit5042.bank.controllers.Users localUser) {
		Users user = new Users(); // entity
		int userId = localUser.getUserId();
		String lastname = localUser.getLastname();
		String firstname = localUser.getFirstname();
		String email = localUser.getEmail();
		String password = localUser.getPassword();
		String userType = localUser.getUserType(); // Bank Worker, Public
		String address = localUser.getAddress();
		String phoneNumber = localUser.getPhoneNumber();

		user.setUserId(userId);
		user.setLastname(lastname);
		user.setFirstname(firstname);
		user.setEmail(email);
		user.setPassword(password);
		user.setUserType(userType);
		user.setAddress(address);
		user.setPhoneNumber(phoneNumber);

		return user;
	}

	public List<Users> getAllProperties() {
		try {

			List<Users> users = userRepository.getAllProperties();
			return users;
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public void removeUser(int userId) {
		try {
			userRepository.removeProperty(userId);
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void editUser(Users user) {
		try {
			userRepository.editUser(user);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been updated succesfully"));
		} catch (Exception ex) {
			Logger.getLogger(UserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Users searchUserById(int userId) {
		try {
            return userRepository.searchUserById(userId);
        } catch (Exception ex) {
            Logger.getLogger(TransactionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

		return null;
	}
}
