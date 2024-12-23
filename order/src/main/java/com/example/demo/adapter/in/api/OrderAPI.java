package com.example.demo.adapter.in.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adapter.in.api.converter.OrderConverter;
import com.example.demo.adapter.in.api.dto.GenericResponseDTO;
import com.example.demo.adapter.in.api.dto.OrderRequestDTO;
import com.example.demo.application.port.in.PlaceOrderUseCase;

import io.opentelemetry.api.trace.Span;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class OrderAPI {
	
	@Autowired
	PlaceOrderUseCase placeOrderUseCase;
	
	@Autowired
	@Qualifier("orderConverterIn")
	OrderConverter orderConverter;
	
	@PostMapping(value = "/api/v1/orders", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
		log.info("POST /api/v1/orders");
		return new ResponseEntity<>(GenericResponseDTO.builder()
				    .code(String.valueOf(HttpStatus.OK.value()))
				    .message(HttpStatus.OK.name())
				    .data(placeOrderUseCase.place(orderConverter.dtoToDo(orderRequestDTO)))
				    .traceId(Span.current().getSpanContext().getTraceId())
				    .build(), HttpStatus.OK);
	}
}
