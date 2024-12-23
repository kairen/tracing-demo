package com.example.demo.application.doamin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.doamin.model.InventoryDo;
import com.example.demo.application.port.in.GetInventoryUseCase;
import com.example.demo.application.port.out.LoadInventoryPort;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GetInventoryService implements GetInventoryUseCase {
	
	@Autowired
	LoadInventoryPort loadInventoryPort;
	
	@Override
	public InventoryDo getInventory(String sku) {
		log.info("Inventroy sku:{} loaded",sku);
		return loadInventoryPort.getInventory(sku);
	}

}
