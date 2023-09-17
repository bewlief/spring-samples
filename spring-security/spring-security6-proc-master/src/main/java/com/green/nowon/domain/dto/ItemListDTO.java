package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.ItemEntity;
import com.green.nowon.domain.entity.ItemImageEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemListDTO {
	
	private long no;
	
	private String title;
	
	private int price;
	
	private int stock;
	
	private LocalDateTime createdDate;
	
	////////////
	//def 이미지 정보들
	
	private String url;
	
	private String bucketKey;
	
	private String orgName;

	private String newName;
	
	//def 이미지만 추가해주는 편의 메소드
	public ItemListDTO defImg(ItemImageEntity ie) {
		url = ie.getUrl();
		bucketKey = ie.getBucketKey();
		orgName = ie.getOrgName();
		newName = ie.getNewName();
		
		return this;
	}

	public ItemListDTO(ItemEntity item) {
		no = item.getNo();
		price = item.getPrice();
		title = item.getTitle();
		stock = item.getStock();
		createdDate = item.getCreatedDate();
	}
	
}
