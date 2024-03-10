package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Royal_Rider")
public class Rider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int personid;
	@Column(length = 35)
	private String name;
	@Column(length = 35)
	private String userName;
	@Column(length = 35)
	private String email; 
	@Column(length = 35)
	private String password;
	@Column
	private long phoneno;
	@Column(length = 15)
	private String city;
	@Column(length = 10)
	private String userrole;
	@Column
	private int age;
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rider(int personid, String name, String userName, String email, String password, long phoneno, String city,
			String userrole, int age) {
		super();
		this.personid = personid;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneno = phoneno;
		this.city = city;
		this.userrole = userrole;
		this.age = age;
	}
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Rider [personid=" + personid + ", name=" + name + ", userName=" + userName + ", email=" + email
				+ ", password=" + password + ", phoneno=" + phoneno + ", city=" + city + ", userrole=" + userrole
				+ ", age=" + age + "]";
	}

}
