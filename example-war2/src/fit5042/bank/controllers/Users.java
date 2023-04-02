package fit5042.bank.controllers;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;
import javax.naming.Context;

@RequestScoped
@Named(value = "users")
public class Users implements Serializable {
	
	private int userId;
	private String lastname;
	private String firstname;
	private String email;
	private String password;
	private String userType;    // Bank Worker, Public
	private String address;
	private String phoneNumber;
	
	/*private Users user;*/
	
	public Users() {
			 
	}
	
	/* public Users getUser() {
		    if (user == null) return new Users();
		    else return user;
		  }
	
	public void validateSamePassword(FacesContext context, UIComponent toValidate, Object value) {
	    String confirmPassword = (String)value;
	    if (!confirmPassword.equals(user.getPassword())) 
	    {
	      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match!", "Passwords do not match!");
	      throw new ValidatorException(message);
	    }
	  }
	*/
	
	public Users(int userId, String lastname, String firstname, String email, String password, String userType,
			String address, String phoneNumber) {
		super();
		this.userId = userId;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastname=" + lastname + ", firstname=" + firstname + ", email=" + email
				+ ", password=" + password + ", userType=" + userType + ", address=" + address + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
