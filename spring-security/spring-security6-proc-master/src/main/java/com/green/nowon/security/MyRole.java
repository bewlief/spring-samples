package com.green.nowon.security;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MyRole {
	
	//enum 필드는 기본적으로 static final 이므로 뒤에 파라미터가 붙으면 오류
	//초기화 해줘야 오류 해결
	//파라미터 필드를 생성하고 final로 설정해서 @RequiredArgsConstructor를 통해서 초기화 하면 오류 해결
	
	USER("ROLE_USER", "일반유저"),		//0
	SELLER("ROLE_SELLER", "판매자"),	//1
	ADMIN("ROLE_ADMIN", "관리자")		//2
	;
	
	//enum의 매개변수
	private final String roleName;
	private final String koName;
	
	
	//getter와 같은 역할
	public String roleName() {
		return roleName;
	}
	
	public String koName() {
		return koName;
	}
	
}
