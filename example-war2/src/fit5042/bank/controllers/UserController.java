package fit5042.bank.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.repository.entities.Users;

@Named(value = "userController")
@RequestScoped
public class UserController {

	private int userId; // this propertyId is the index, don't confuse with the Property Id

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private Users user;

	public UserController() {
		userId = Integer
				.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("userID"));
		// Assign property based on the id provided
		user = getUser();
	}

	public Users getUser() {
		if (user == null) {
			// Get application context bean PropertyApplication
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			UserApplication app = (UserApplication) FacesContext.getCurrentInstance().getApplication().getELResolver()
					.getValue(context, null, "userApplication");
			// -1 to propertyId since we +1 in JSF (to always have positive property id!)
			return app.getUsers().get(--userId); // this propertyId is the index, don't confuse with the Property Id
		}
		return user;
	}

}
