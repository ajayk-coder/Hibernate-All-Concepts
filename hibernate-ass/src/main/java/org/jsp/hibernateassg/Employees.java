package org.jsp.hibernateassg;

public class Employees {
private int id;
private String name;
private long phon;
private String email;
private String designation;
private double salary;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getPhon() {
	return phon;
}
public void setPhon(long phon) {
	this.phon = phon;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Employees [id=" + id + ", name=" + name + ", phon=" + phon + ", email=" + email + ", designation="
			+ designation + ", salary=" + salary + ", password=" + password + "]";
} 

}
