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
@Table(name="SHIPPING_DETAILS")
public class Shipping implements Serializable {

	public Shipping()
	{
		shipId = UUID.randomUUID().toString().toUpperCase();
	}
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name="Shipping_Id")
	private String shipId;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="Address")
	private String shipAdd;	

	@NotEmpty(message = "*cannot be null")
	@Column(name="City")
	private String shipCity;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="State")
	private String shipState;
	
	@NotEmpty(message = "*cannot be null")
	@Column(name="Zipcode")
	private String shipZip;
	
	public String getShipId() {
		return shipId;
	}

	public void setShipId(String shipId) {
		this.shipId = shipId;
	}

	public String getShipAdd() {
		return shipAdd;
	}

	public void setShipAdd(String shipAdd) {
		this.shipAdd = shipAdd;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	public String getShipZip() {
		return shipZip;
	}

	public void setShipZip(String shipZip) {
		this.shipZip = shipZip;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@NotEmpty(message = "*cannot be null")
	@Column(name="Country")
	private String shipCountry;
		
	@OneToOne(mappedBy="shipping")
	User u;
}