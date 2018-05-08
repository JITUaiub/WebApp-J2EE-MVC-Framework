package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.webappmvc.mvc.model.Model;
import dao.UsersDao;

@Entity(name = "users") 
@Table(name="users")
public class Users implements Model{
	@Id
	@Column(name="username", nullable = false) 
	private String userName;
	@Column(name="name") 
	private String name;
	@Column(name="dob") 
	private String dob;
	@Column(name="gender") 
	private String gender;
	
	public Users() {
		
	}
	
	public Users(String userName, String name, String dob, String gender) {
		super();
		this.userName = userName;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<?> getDataAsArrayList() {
		return UsersDao.getUser();
	}

}
