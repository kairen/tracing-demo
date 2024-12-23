package com.example.demo.adapter.out.persistence.repository.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.adapter.out.persistence.repository.po.CatalogPo;
import com.example.demo.application.doamin.model.CatalogDo;

@Service
public class CatalogConverter {
	
	public CatalogDo poToDo(CatalogPo catalogPo) {
		return CatalogDo.builder()
				.sku(catalogPo.getSku())
				.pruductName(catalogPo.getProductName())
				.desc(catalogPo.getDesc())	
				.price(catalogPo.getPrice())
				.img(catalogPo.getImg())
				.build();
	}
	
	public List<CatalogDo> poToDo(List<CatalogPo> catalogPos) {
		List<CatalogDo> catalogDos=new ArrayList<>();
		catalogPos.forEach(item->{
			catalogDos.add(this.poToDo(item));
		});
		return catalogDos;
	}

}
