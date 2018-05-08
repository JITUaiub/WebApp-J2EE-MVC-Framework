package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.webappmvc.mvc.model.Model;

import dao.UserLoginDao;

@Entity(name = "userlogin") 
@Table(name="userlogin")
public class UserLogin implements Model{
	@Id
	@Column(name="username", nullable = false) 
	private String userName;
	@Column(name="password") 
	private String password;
	
	public UserLogin() {
		
	}
	
	public UserLogin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<?> getDataAsArrayList() {
		return UserLoginDao.getUser();
	}

}
