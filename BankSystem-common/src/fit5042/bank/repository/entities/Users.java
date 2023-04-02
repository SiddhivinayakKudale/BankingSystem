package fit5042.bank.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;



@Entity
@NamedQueries({
    @NamedQuery(name = Users.GET_ALL_QUERY_NAME, query = "SELECT u FROM Users u"),
    @NamedQuery(name = Users.GET_USERID_QUERY_NAME, query = "SELECT u FROM Users u WHERE u.email = :username")
})
@Table(name = "users")
public class Users implements Serializable {
	
	public static final String GET_ALL_QUERY_NAME = "Users.getAll";
	public static final String GET_USERID_QUERY_NAME = "Users.getUserId";
	
	private int userId;
	
	@NotNull(message= "LastName cannot be null")
	@Size(min=1, max=16)
	private String lastname;
	
	@NotNull(message= "FirstName cannot be null")
	@Size(min=1, max=16)
	private String firstname;
	
	@NotNull(message= "Email cannot be null")
	private String email;
	
	@NotNull(message= "Password cannot be null")
	private String password;
	
	@NotNull(message= "UserType cannot be null")
	private String userType;    // Bank Worker, Public
	
	@NotNull(message= "Address cannot be null")
	private String address;
	
	@Min(value = 10, message = "Phone Number should not be less than 10")
	@Max(value = 10, message = "Phone Number should not be greater than 10")
	private String phoneNumber;
	
	private Set<Account> accounts;
	
	public Users() {
		super();
		this.accounts = new HashSet<>();
		// TODO Auto-generated constructor stub
	}
	
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
		this.accounts = new HashSet<>();
	}
	
	
	
	@OneToMany(mappedBy="user")
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
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
