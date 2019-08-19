package com.example.demo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Person")
public class Person implements Serializable{
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final int serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty
	private int id;
	@Column(name = "email")
private String email;
@Override
public String toString() {
	return "Person [email=" + email + "]";
}
@Column(name = "password")
private String password;
@Column(name = "option")
private String option;
@Column(name = "otp")
private String otp;
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public String getOption() {
	return option;
}
public void setOption(String option) {
	this.option = option;
}
@Column(name = "ans1")
private String ans1;
@Column(name = "ans2")
private String ans2;
public String getAns1() {
	return ans1;
}
public void setAns1(String ans1) {
	this.ans1 = ans1;
}
public String getAns2() {
	return ans2;
}
public void setAns2(String ans2) {
	this.ans2 = ans2;
}
public String getChoice() {
	return choice;
}
public void setChoice(String choice) {
	this.choice = choice;
}

private String choice;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
