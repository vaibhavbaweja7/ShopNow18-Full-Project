package com.niit.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "User")

public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "UserId")
	private int userId;
	
	@NotNull
	@NotEmpty(message = "*cannot be null")
	@Column(name = "Name")
	private String name;
	
	
	@NotNull
	@NotEmpty(message = "*cannot be null")
	@Email(message="*enter a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="*enter a valid email address")	
	@Column(name = "Email", unique = true)
	private String email;
	
	@NotNull
	@NotEmpty(message = "*cannot be null")
	@Size(min=4,max=12,message="*should be 4-12 characters")
	@Column(name = "Username")
	private String uname;
	
	@NotNull
	@NotEmpty(message = "*cannot be null")
	@Size(min=6,max=14,message="*should be 6-14 characters")
	@Column(name = "Password")
	private String pass;
	
	@NotNull
	@NotEmpty(message = "*cannot be null")
	@Pattern(regexp="[0-9]{10}", message="*enter a valid number")	
	@Column(name = "MobileNo")
	private String mobile;
	
	@NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billId")
	private Billing billing;
	
     @NotNull
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	private boolean enable;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	
}
