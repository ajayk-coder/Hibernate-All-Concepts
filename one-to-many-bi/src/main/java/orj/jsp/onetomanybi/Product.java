package orj.jsp.onetomanybi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String brand,category,description, name;
@Column(nullable=false)
private double cost;

@ManyToOne
@JoinColumn(name = "merchant_id")
private Merchant m;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public Merchant getM() {
	return m;
}

public void setM(Merchant m) {
	this.m = m;
}

@Override
public String toString() {
	return "Product [id=" + id + ", brand=" + brand + ", category=" + category + ", description=" + description
			+ ", name=" + name + ", cost=" + cost + ", m=" + m + "]";
}


}
