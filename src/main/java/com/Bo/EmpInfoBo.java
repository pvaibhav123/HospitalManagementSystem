package com.Bo;

public class EmpInfoBo 
{
  private int id;
  public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String name;
  private String email;
  private String phone;
  private String specialisation;
  private String address;
  
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public String getspecialisation() {
	return specialisation;
}
public void setspecialisation(String specialisation) {
	this.specialisation = specialisation;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}



public EmpInfoBo(int id, String name, String email, String phone, String specialisation, String address) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.specialisation = specialisation;
	this.address = address;
}
public EmpInfoBo(String name, String email, String phone, String specialisation, String address) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.specialisation = specialisation;
	this.address = address;
	
}
public EmpInfoBo() {
	super();
	// TODO Auto-generated constructor stub
}
  

  
}
