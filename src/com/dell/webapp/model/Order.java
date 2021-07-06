package com.dell.webapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="eproduct_order")
public class Order {

	// properties
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "order_name")
	private String name;

	@Column(name = "total_price")
	private Double totalPrice;
	
	@Column(name = "customer_name")
	private String customerName;	
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Product> products;

	public Order() {}

	public Order(int id, String name, Double totalPrice, String customerName, String customerPhone) {
		super();
		this.id = id;
		this.name = name;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
	}

	public Order(String name, Double totalPrice, String customerName, String customerPhone) {
		super();
		this.name = name;
		this.totalPrice = totalPrice;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getcustomerPhone() {
		return customerPhone;
	}

	public void setcustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", totalPrice=" + totalPrice + ", customerName=" + customerName
				+ ", customerPhone=" + customerPhone + "]";
	}	

}
