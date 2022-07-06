package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Bank {

@Id
 private Integer id;
 private String name;
 private String loc;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLoc() {
	return loc;
}
public void setLoc(String loc) {
	this.loc = loc;
}
public Bank(Integer id, String name, String loc) {
	super();
	this.id = id;
	this.name = name;
	this.loc = loc;
}
public Bank() {
	super();
	// TODO Auto-generated constructor stub
}
 
 
}
