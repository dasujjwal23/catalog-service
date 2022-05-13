package com.example.catalogservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catagory")
public class Catagory {

	@Id
	private int orderId;
	
	private String catagory;
	private String color;
	private double price;
	
	public int getId() {
		return orderId;
	}
	public void setId(int orderId) {
		this.orderId = orderId;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Catagory(int orderId, String catagory, String color, double price) {
		super();
		this.orderId = orderId;
		this.catagory = catagory;
		this.color = color;
		this.price = price;
	}
	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
