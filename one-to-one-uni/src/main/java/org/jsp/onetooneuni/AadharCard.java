package org.jsp.onetooneuni;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value= {
@NamedQuery(name="FindAadharcardByid",query="select a from AadharCard a where a.id=?1")		,
@NamedQuery(name="FindAadharcardByNumber",query="select a from AadharCard a where a.number=?1"),
@NamedQuery(name="FindAadharCardByNumberAndDob",query="select a from AadharCard a where a.number=?1 and a.date_of_birth=?2")
})
public class AadharCard {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false,unique=true)
private long number;
@Column(nullable=false)
private LocalDate date_of_birth;
@Column(nullable=false)
private int pincode;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}
public LocalDate getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(LocalDate date_of_birth) {
	this.date_of_birth = date_of_birth;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
@Override
public String toString() {
	return "AadharCard [id=" + id + ", number=" + number + ", date_of_birth=" + date_of_birth + ", pincode=" + pincode
			+ "]";
}



}
