package com.dell.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eproduct_payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="payment_id")
	private int id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="price")
	private Double price;

	public Payment(int id, String customerName, Double price) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.price = price;
	}

	public Payment(String customerName, Double price) {
		super();
		this.customerName = customerName;
		this.price = price;
	}

	public Payment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
