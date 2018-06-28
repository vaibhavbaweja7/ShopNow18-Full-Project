package com.niit.Backend.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="BILLING_DETAILS")
public class Billing implements Serializable {

	public Billing()
	{
		billId = UUID.randomUUID().toString().toUpperCase();
	}
	
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getBillAdd() {
		return billAdd;
	}

	public void setBillAdd(String billAdd) {
		this.billAdd = billAdd;
	}

	public String getBillCity() {
		return billCity;
	}

	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}

	public String getBillState() {
		return billState;
	}

	public void setBillState(String billState) {
		this.billState = billState;
	}

	public String getBillZip() {
		return billZip;
	}

	public void setBillZip(String billZip) {
		this.billZip = billZip;
	}

	public String getBillCountry() {
		return billCountry;
	}

	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Billing_Id")
	private String billId;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="Address")
	private String billAdd;	

	@NotEmpty(message = "*cannot be null")
	@Column(name="City")
	private String billCity;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="State")
	private String billState;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="Zipcode")
	private String billZip;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="Country")
	private String billCountry;
		
	@OneToOne(mappedBy="billing")
	User u;

	
}
