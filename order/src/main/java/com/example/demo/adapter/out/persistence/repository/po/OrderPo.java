package com.example.demo.adapter.out.persistence.repository.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_INFO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPo {

	@Id
	@Column(name = "ORDER_ID")
	private String orderId;

	@Column(name = "SKU")
	private String sku;

	@Column(name = "AMT")
	private int amt;

}
