package org.jsp.onetoonebi;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;



@Entity
@NamedQueries(value= {
@NamedQuery(name="FindPanCardById",query="select p from PanCard p where p.id=?1")		,
@NamedQuery(name="FindPanCardByNumber",query="select p from PanCard p where p.number=?1"),
//@NamedQuery(name="FindAadharCardByNumberAndDob",query="select a from AadharCard a where a.number=?1 and a.date_of_birth=?2")
})
public class PanCard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false,unique=true)
	private String number;
	@Column(nullable=false)
	private LocalDate date_of_birth;
	@Column(nullable=false)
	private int pincode;
	@OneToOne(mappedBy="card")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "PanCard [id=" + id + ", number=" + number + ", date_of_birth=" + date_of_birth + ", pincode=" + pincode
				+ ", user=" + user + "]";
	}
	
	
	
	
	
}
	