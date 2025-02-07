package orj.jsp.onetomanybi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String name;
@Column(nullable=false, unique = true)
private long phone;
@Column(nullable=false, unique = true)
private String gst_number;
@Column(nullable=false)
private String password;
@OneToMany(cascade = CascadeType.ALL, mappedBy= "m")
private List<Product> products;
public List<Product> getProducts() {
	return products;
}
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
public String getGst_number() {
	return gst_number;
}
public void setGst_number(String gst_number) {
	this.gst_number = gst_number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
@Override
public String toString() {
	return "Merchant [id=" + id + ", name=" + name + ", phone=" + phone + ", gst_number=" + gst_number + ", password="
			+ password + "]";
}


}

