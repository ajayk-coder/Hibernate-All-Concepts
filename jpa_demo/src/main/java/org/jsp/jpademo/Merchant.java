package org.jsp.jpademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="merchant")
@NamedQueries(value= {
@NamedQuery(name="findbyName",query="select m from Merchant m where m.name=?1"),
@NamedQuery(name="VerifyByphonAndPassword",query="select m from Merchant m where m.phon=?1 and m.password=?2"),
@NamedQuery(name="VerifyByEmailAndPassword",query="select m from Merchant m where m.email=?1 and m.password=?2"),
@NamedQuery(name="findbygstnumber",query="select m from Merchant m where m.gst_number=?1"),
@NamedQuery(name="findbyphon",query="select m from Merchant m where m.phon=?1"),
@NamedQuery(name="findbyemail",query="select m from Merchant m where m.email=?1"),
@NamedQuery(name="findbyid",query="select m from Merchant m where m.id=?1"),

@NamedQuery(name="verifyByIdAndPassword",query="select m from Merchant m where m.id=?1 and m.password=?2"),
@NamedQuery(name="listAllName",query="select m.name from Merchant m")
		})
public class Merchant {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String name;
@Column(nullable=false,unique=true)
private long phon;
@Column(nullable=false,unique=true)
private String gst_number;
@Column(nullable=false,unique=true)
private String email;
@Column(nullable=false)
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
public String getGst_number() {
	return gst_number;
}
public void setGst_number(String gst_number) {
	this.gst_number = gst_number;
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
@Override
public String toString() {
	return "Merchant [id=" + id + ", name=" + name + ", phon=" + phon + ", gst_number=" + gst_number + ", email="
			+ email + "]";
}


}
