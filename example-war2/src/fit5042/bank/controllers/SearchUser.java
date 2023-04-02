package fit5042.bank.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@RequestScoped
@Named("searchUser")
public class SearchUser {
	private boolean showForm = true;
	
	private Users user;
	
	UserApplication app;
	
	private int searchByInt;

	public SearchUser() {
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		app = (UserApplication) FacesContext.getCurrentInstance()
				.getApplication()
				.getELResolver()
				.getValue(context, null, "userApplication");

		app.updateUserList();
	}
	
	public void searchUserById(int userId) {
        try {
            //search this property then refresh the list in PropertyApplication bean
            app.searchUserById(userId);
        } catch (Exception ex) {

        }
        showForm = true;

    }

	public boolean isShowForm() {
		return showForm;
	}

	public void setShowForm(boolean showForm) {
		this.showForm = showForm;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public UserApplication getApp() {
		return app;
	}

	public void setApp(UserApplication app) {
		this.app = app;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}
	
	public void searchAll() {
		app.searchAll();
	}
}
