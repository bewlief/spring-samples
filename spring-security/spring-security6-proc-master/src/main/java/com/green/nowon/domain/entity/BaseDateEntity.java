package com.green.nowon.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;

@Getter
@MappedSuperclass //super class 로만 사용할 것
//추상 클래스: 단독으로 객체 생성 불가
public abstract class BaseDateEntity {
	
	@CreationTimestamp
	@Column(columnDefinition = "timestamp")
	private LocalDateTime createdDate;
	
	//@LastModifiedDate //아래 어노테이션과 유사한 기능이지만 추가 설정이 필요(귀찮음)
	@UpdateTimestamp
	@Column(columnDefinition = "timestamp")
	private LocalDateTime updatedDate;

}
