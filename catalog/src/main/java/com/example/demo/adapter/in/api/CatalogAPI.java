package com.example.demo.adapter.in.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.adapter.in.api.dto.GenericResponseDTO;
import com.example.demo.application.port.in.GetCatalogUseCase;

import io.opentelemetry.api.trace.Span;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class CatalogAPI {
	
	@Autowired
	GetCatalogUseCase getCatalogUseCase;
	
	
	@GetMapping(value = "/api/v1/catalogs", produces = "application/json")
	public ResponseEntity<GenericResponseDTO> getCatalog() {
		log.info("GET /api/v1/catalogs");
		return new ResponseEntity<>(GenericResponseDTO.builder()
				    .code(String.valueOf(HttpStatus.OK.value()))
				    .message(HttpStatus.OK.name())
				    .data(getCatalogUseCase.getAllCatalog())
				    .traceId(Span.current().getSpanContext().getTraceId())
				    .build(), HttpStatus.OK);
	}
	
	 @GetMapping("/api/v1/catalogs/{sku}")
	 public ResponseEntity<GenericResponseDTO> getCatalog(@PathVariable String sku) {
		 log.info("GET /api/v1/catalogs/{}",sku);
			return new ResponseEntity<>(GenericResponseDTO.builder()
				    .code(String.valueOf(HttpStatus.OK.value()))
				    .message(HttpStatus.OK.name())
				    .data(getCatalogUseCase.getCatalog(sku))
				    .traceId(Span.current().getSpanContext().getTraceId())
				    .build(), HttpStatus.OK);
	 }
}
