package org.jsp.onetoonebi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
@NamedQueries(value= {
@NamedQuery(name="FindUserByName",query="select u from User u where u.name=?1 "),
@NamedQuery(name="FindUserByPhone",query="select u from User u where u.phone=?1"),

})
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)	
	private String name;
	@Column(unique=true,nullable=false)
	private long phone;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="pancard_id")
	private PanCard card;

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

	public PanCard getCard() {
		return card;
	}

	public void setCard(PanCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	

	
	


}





