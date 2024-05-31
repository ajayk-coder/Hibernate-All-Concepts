package hibernate_demo1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee1")
public class Employee1 {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column (name="name",nullable=false,length=45)
private String name;
@Column (name="phon",nullable=false,unique=true)
private long phon;
@Column (nullable=false,unique=true)
private String email;
@Column (nullable=false)
private String designation;
@Column (nullable=false)
private double salary;
@Column (nullable=false)
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


}
