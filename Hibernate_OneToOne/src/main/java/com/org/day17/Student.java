package com.org.day17;

import javax.persistence.*;

@Entity
@Table(name="Student")
public class Student {

    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)  
    @PrimaryKeyJoinColumn  
private int Id;    
private String name, email;    
@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
private Address address_id;

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
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
public Address getAddress_id() {
	return address_id;
}
public void setAddress_id(Address address_id) {
	this.address_id = address_id;
} 


}
