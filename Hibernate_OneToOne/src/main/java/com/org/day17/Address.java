package com.org.day17;

import javax.persistence.*;

@Entity
@Table(name="Address")

public class Address {
	
	@Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
private int address_id;    
private String addressLine1,city,state,country;    
private int pincode;    
  
@OneToOne(targetEntity=Student.class)  
private Student student;

public int getAddress_id() {
	return address_id;
}

public void setAddress_id(int address_id) {
	this.address_id = address_id;
}

public String getAddressLine1() {
	return addressLine1;
}

public void setAddressLine1(String addressLine1) {
	this.addressLine1 = addressLine1;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}  
	

}
