package com.one.many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="STUDENT", uniqueConstraints = {
@UniqueConstraint(columnNames = "ID"),
@UniqueConstraint(columnNames = "EMAIL")})
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID", unique = true, nullable = false)
private int id;
@Column(name = "NAME", unique = false, nullable = false, length = 100)
private String name;
@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
private String email;
@OneToOne
@JoinColumn(name="address_id")
private Address address;
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="Student_ID")

private List<Account> accounts = new ArrayList<Account>();



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



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public Address getAddress() {
	return address;
}



public void setAddress(Address address) {
	this.address = address;
}



public List<Account> getAccounts() {
	return accounts;
}



public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
}


}

