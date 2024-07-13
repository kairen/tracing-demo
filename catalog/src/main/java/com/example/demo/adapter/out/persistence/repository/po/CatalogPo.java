package com.example.demo.adapter.out.persistence.repository.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CATALOG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogPo {

	@Id
	@Column(name = "SKU")
	private String sku;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "DESCRIPTION")
	private String desc;

	@Column(name = "PRICE")
	private long price;

	@Column(name = "IMAGE")
	private String img;
}
