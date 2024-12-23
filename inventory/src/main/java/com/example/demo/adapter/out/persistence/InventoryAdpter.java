package com.example.demo.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.adapter.out.persistence.repository.InventoryRepository;
import com.example.demo.adapter.out.persistence.repository.converter.InventoryConverter;
import com.example.demo.application.doamin.model.InventoryDo;
import com.example.demo.application.port.out.LoadInventoryPort;

@Service
public class InventoryAdpter implements LoadInventoryPort{
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	InventoryConverter inventoryConverter;

	@Override
	public InventoryDo getInventory(String sku) {
		return inventoryConverter.poToDo(inventoryRepository.findById(sku).get());
	}

}
