package com.eliatech.stockmanagement.productservice.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product", schema="stock_management")
public class Product {
	
	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long productId;
	
	@Column(name="")
	private String productName;
	
	@Column(name="")
	private int quantity;
	
	@Column(name="price")
	private double price;
	
	
	
	//bu alanı contructorda default olarak her zaman geçmesi için
	@Builder.Default
	@Column(name="product_updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd")
	private Date productUpdatedDate= new Date();
	
	@Builder.Default
	@Column (name= "product_created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern ="yyyy-MM-dd")
	private Date productCreatedDate = new Date();
	
	@Column(name ="is_deleted")
	private boolean deleted;
	
	
	

}
