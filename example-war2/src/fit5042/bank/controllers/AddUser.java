package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.bank.mbeans.UserManagedBean;

@RequestScoped
@Named("addUser")
public class AddUser {

	@ManagedProperty(value = "#{userManagedBean}")
	UserManagedBean userManagedBean;

	UserApplication app;

	public AddUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (UserApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "userApplication");

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "userManagedBean");
	}

	// Code for adding the user
	public void addUser(Users localUser) {
		// this is the local property, not the entity
		try {
			// add this property to db via EJB
			userManagedBean.addUser(localUser);

			// refresh the list in PropertyApplication bean
			app.searchAll();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been added succesfully"));
		} catch (Exception ex) {

		}
	}
}
