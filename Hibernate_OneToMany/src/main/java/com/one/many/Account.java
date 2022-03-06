package com.one.many;

import javax.persistence.*;

@Entity(name = "ForeignKeyAssoAccountEntity")
@Table(name = "ACCOUNT", uniqueConstraints = {
@UniqueConstraint(columnNames = "ACCOUNT_ID")})
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ACCOUNT_ID", unique = true, nullable = false)
private Integer account_id;
@Column(name = "USERNAME", unique = true, nullable = false, length = 20)
private String username;
@ManyToOne
private Student student;



public Integer getAccount_id() {
	return account_id;
}



public void setAccount_id(Integer account_id) {
	this.account_id = account_id;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public Student getStudent() {
	return student;
}



public void setStudent(Student student) {
	this.student = student;
}



@Override
public String toString() {
return "Account [account_id=" + account_id + ", username=" + username + ", student=" + student.getName() + "]";
}
}
