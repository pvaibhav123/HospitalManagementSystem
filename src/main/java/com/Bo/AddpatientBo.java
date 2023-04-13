package com.Bo;

public class AddpatientBo 
{
	private int id;
	private String name;
	private String date;
	private String email;
	private String phone;
	private String diesease;
	private String alloted_doctor;
	private int registration_fee;
	
	
	
public String getDiesease() {
		return diesease;
	}
	public void setDiesease(String diesease) {
		this.diesease = diesease;
	}
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public AddpatientBo(int id) {
		super();
		this.id = id;
	}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getdiesease() {
	return diesease;
}
public void setdiesease(String diesease) {
	this.diesease = diesease;
}
public String getAlloted_doctor() {
	return alloted_doctor;
}
public void setAlloted_doctor(String alloted_doctor) {
	this.alloted_doctor = alloted_doctor;
}
public int getRegistration_fee() {
	return registration_fee;
}
public void setRegistration_fee(int registration_fee) {
	this.registration_fee = registration_fee;
	
	
}
public AddpatientBo(int id,String name, String date, String email, String phone, String diesease, String alloted_doctor,
		int registration_fee) {
	super();
	this.id=id;
	this.name = name;
	this.date = date;
	this.email = email;
	this.phone = phone;
	this.diesease = diesease;
	this.alloted_doctor = alloted_doctor;
	this.registration_fee = registration_fee;
	
}
public AddpatientBo(String name,String date,String email,String phone,String diesease,String alloted_doctor,int registration_fee) {
	
	this.name = name;
	this.date = date;
	this.email = email;
	this.phone = phone;
	this.diesease = diesease;
	this.alloted_doctor = alloted_doctor;
	this.registration_fee = registration_fee;
}
public AddpatientBo() {
	super();
	// TODO Auto-generated constructor stub
}
}
