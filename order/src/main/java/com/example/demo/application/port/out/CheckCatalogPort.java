package com.example.demo.application.port.out;

import com.example.demo.application.doamin.model.OrderDo;

public interface CheckCatalogPort {
	/**
	 * Check catalog 
	 * @return
	 */
	boolean check(OrderDo orderDo);
	
}
