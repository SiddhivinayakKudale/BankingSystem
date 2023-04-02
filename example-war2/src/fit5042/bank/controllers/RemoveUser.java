package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.bank.repository.entities.Users;
import fit5042.bank.mbeans.UserManagedBean;

@RequestScoped
@Named("removeUser")
public class RemoveUser {

	@ManagedProperty(value = "#{userManagedBean}")
	UserManagedBean userManagedBean;

	UserApplication app;

	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public RemoveUser() {
		ELContext context = FacesContext.getCurrentInstance().getELContext();

		app = (UserApplication) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(context,
				null, "userApplication");

		// instantiate userManagedBean
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		userManagedBean = (UserManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "userManagedBean");
	}

	public void removeUser(int userId) {
		try {
			System.out.println("User id is" + userId);
			// remove this property from db via EJB
			userManagedBean.removeUser(userId);

			app.searchAll();

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been deleted succesfully"));
		} catch (Exception ex) {

		}

	}

}
