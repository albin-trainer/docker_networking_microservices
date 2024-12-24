package com.example.model;

public class Product {
private int prodId;
private String prodName;
private float price;
private String port;
//{"prodId":101,"prodName":"ssss","price":1000}
public Product() {
	// TODO Auto-generated constructor stub
}

public Product(int prodId, String prodName, float price, String port) {
	super();
	this.prodId = prodId;
	this.prodName = prodName;
	this.price = price;
	this.port = port;
}

public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public String getProdName() {
	return prodName;
}
public void setProdName(String prodName) {
	this.prodName = prodName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public String getPort() {
	return port;
}
public void setPort(String port) {
	this.port = port;
}



}
