package com.example.demo.application.doamin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InventoryDo {
	
	private String sku;	

	private String pruductName;

	private int amt;
	
}
