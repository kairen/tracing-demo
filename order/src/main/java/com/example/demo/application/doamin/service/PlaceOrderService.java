package com.example.demo.application.doamin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.doamin.model.OrderDo;
import com.example.demo.application.port.in.PlaceOrderUseCase;
import com.example.demo.application.port.out.CheckCatalogPort;
import com.example.demo.application.port.out.CheckInventoryPort;
import com.example.demo.application.port.out.SaveOrderPort;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PlaceOrderService implements PlaceOrderUseCase {
	
	@Autowired
	SaveOrderPort saveOrderPort;
	
	@Autowired
	CheckCatalogPort checkCatalogPort;
	
	@Autowired
	CheckInventoryPort checkInventoryPort;
	
	@Override
	public String place(OrderDo orderDo) {
		// Create Order Id
		orderDo.createOrderId();
		log.info("Order Id:{} Created",orderDo.getOrderId());
		
		// Check SKU 
		checkCatalogPort.check(orderDo);
		
		// Check Inventory
		checkInventoryPort.check(orderDo);
		
		// Place Order
		saveOrderPort.save(orderDo);
		
		return orderDo.getOrderId();
	}	
	




}
