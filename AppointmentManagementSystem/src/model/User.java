package model;

public class User 
{
	int empid;
	String name;
	String password;
	
	String role;
	
	
	public User( int empid2,String name, String password,  String role) {
		super();
		this.empid = empid2;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	public int getEmpid() {
		return empid;
	}
	public void setUserid(int empid) {
		this.empid = empid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userid=" + empid + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
}
