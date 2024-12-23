package com.example.demo.adapter.out.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.application.doamin.model.OrderDo;
import com.example.demo.application.port.out.CheckCatalogPort;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CheckCatalogAdapter implements CheckCatalogPort {

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${services.catalog}")
	private String catalogResourceURL;	
	
	@Override
	public boolean check(OrderDo orderDo) {
		String catalogURL = new StringBuilder()
				.append(catalogResourceURL)
				.append(orderDo.getSku())
				.toString();
		log.info("Check SKU URL:{}",catalogURL);
		restTemplate.getForObject(catalogURL, String.class);
		log.info("Check SKU:{}",orderDo.getSku());
		return true;
	}

}
