package com.ibeifeng;

import java.io.Serializable;

public class User implements Serializable{

	private String name;
	private String sex;
	private int id;
	
	
	public User(){}
	public User(String name, String sex, int id) {
		super();
		this.name = name;
		this.sex = sex;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
