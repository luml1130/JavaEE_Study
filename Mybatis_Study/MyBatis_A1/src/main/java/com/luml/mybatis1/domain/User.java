package com.luml.mybatis1.domain;

/**
 * @author luml
 */
public class User {
	private Integer id;
	private String name;
	private String password;
	private String address;
	
	public User() {}
	
	public User(String name, String password, String address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [address=" + address + ", id=" + id + ", name=" + name
				+ ", password=" + password + "]";
	}
	
	
}
