
package com.Bo;

public class EmpBo 
{
    private String name;
    private String email;
    private String phone;
    private String password;
    private String confirm;
    
    
	public String getPhone() {
		return phone;
	}
	
	public EmpBo(String name, String email, String phone, String password, String confirm) 
	{
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.confirm = confirm;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public EmpBo() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	
    
}
