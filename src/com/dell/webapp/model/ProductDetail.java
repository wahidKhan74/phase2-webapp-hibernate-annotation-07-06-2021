package com.dell.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eproduct_details")
public class ProductDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dimentions")
	private int dimentions;
	
	@Column(name="description")
	private String description;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="stock")
	private int stock;

	public ProductDetail(int id, int dimentions, String description, String brand, int weight, int stock) {
		super();
		this.id = id;
		this.dimentions = dimentions;
		this.description = description;
		this.brand = brand;
		this.weight = weight;
		this.stock = stock;
	}

	public ProductDetail(int dimentions, String description, String brand, int weight, int stock) {
		super();
		this.dimentions = dimentions;
		this.description = description;
		this.brand = brand;
		this.weight = weight;
		this.stock = stock;
	}

	public ProductDetail() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDimentions() {
		return dimentions;
	}

	public void setDimentions(int dimentions) {
		this.dimentions = dimentions;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", dimentions=" + dimentions + ", description=" + description + ", brand="
				+ brand + ", weight=" + weight + ", stock=" + stock + "]";
	}

	
}
