package org.jsp.onetooneuni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
@NamedQueries(value= {
@NamedQuery(name="FindPersonByName",query="select p from person p where p.name=?1 "),
@NamedQuery(name="FindPersonByPhone",query="select p from person p where p.phone=?1"),

})


public class person {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String name;
private long phone;
@OneToOne
private AadharCard aadhar;
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
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public AadharCard getAadhar() {
	return aadhar;
}
public void setAadhar(AadharCard aadhar) {
	this.aadhar = aadhar;
}
@Override
public String toString() {
	return "person [id=" + id + ", name=" + name + ", phone=" + phone + ", aadhar=" + aadhar + "]";
}


}
