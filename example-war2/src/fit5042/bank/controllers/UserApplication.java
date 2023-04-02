package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import fit5042.bank.repository.entities.Users;
import fit5042.bank.mbeans.UserManagedBean;


@Named(value = "userApplication")
@ApplicationScoped
public class UserApplication {
	
    
	@ManagedProperty(value = "#{userManagedBean}")
	UserManagedBean userManagedBean;

	private ArrayList<Users> users; // arraylist to store all the values retrived from db

	public ArrayList<Users> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<Users> users) {
		this.users = users;
	}

	public UserApplication() {
		users = new ArrayList<>();

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "userManagedBean");

		// get users from db
		updateUserList();
	}

	public void updateUserList() {
		// TODO Auto-generated method stub
		if (users != null && users.size() > 0) {

		} else {
			users.clear();

			for (fit5042.bank.repository.entities.Users user : userManagedBean.getAllProperties()) {
				users.add(user);
			}

			setUsers(users);
		}

	}

	public void searchAll() {
		// TODO Auto-generated method stub
		users.clear();
		for (fit5042.bank.repository.entities.Users user : userManagedBean.getAllProperties()) {
			users.add(user);
		}
		setUsers(users);
	}
	
	public Users call() {
		Client client = ClientBuilder.newClient();
		Users obj =  client.target("http://localhost:8080/example-war2/resources/MyRestService/object").request().get(Users.class);
		return obj;
	}
	
	public Account callAccount() {
		Client client = ClientBuilder.newClient();
		Account obj =  client.target("http://localhost:8080/example-war2/resources/MyRestService/getAcc").request().get(Account.class);
		return obj;
	}
	
	

	public void searchUserById(int userId) {
		users.clear();

		users.add(userManagedBean.searchUserById(userId));
		
	}
}
