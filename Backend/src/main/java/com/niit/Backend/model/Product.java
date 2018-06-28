package com.niit.Backend.model;
import javax.persistence.*;
import com.niit.Backend.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name = "Product")
public class Product {
	@Id
	private String productId;
	private String productName;
	private String productDescription;
	private String productPrice;
	private String productQuantity;
	private String categoryId;
	@Transient
	private MultipartFile file;	
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@ManyToOne
	@JoinColumn(name = "categoryId", insertable=false,nullable = false,updatable=false)
	private Category category;

	

	public String getProductId() { 
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(String productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	}

