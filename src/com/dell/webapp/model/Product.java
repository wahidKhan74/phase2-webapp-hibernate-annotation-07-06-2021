package com.dell.webapp.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//This is  Encapsulated class, POJO,  Bean
@Entity
@Table(name="eproduct_data")
public class Product {
	
	// properties
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="modified_at")
	private Date modifiedAt;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private ProductDetail detail;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Order order;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="product_payment", joinColumns=@JoinColumn(name="id")
	,inverseJoinColumns=@JoinColumn(name="payment_id"))
	private Set<Payment> payments;
	
	// constructor
	public Product() {}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}
	
	public Product(int id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}
	
	public Product(int id) {
		this.id = id;
	}
	
	//get & set methods
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public ProductDetail getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + "]";
	}
}

