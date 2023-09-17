package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.CategoryEntity;

import lombok.Getter;

@Getter
public class CategoryListDTO {
	
	private long no;
	
	private String name;
	
	public CategoryListDTO(CategoryEntity entity) {
		no=entity.getNo();
		name=entity.getName();
	}

}
