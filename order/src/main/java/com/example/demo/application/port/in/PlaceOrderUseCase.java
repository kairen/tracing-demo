package com.example.demo.application.port.in;

import com.example.demo.application.doamin.model.OrderDo;

public interface PlaceOrderUseCase {

	/**
	 * 下訂單
	 * @param orderDo
	 * @return
	 */
	String place(OrderDo orderDo);

}
