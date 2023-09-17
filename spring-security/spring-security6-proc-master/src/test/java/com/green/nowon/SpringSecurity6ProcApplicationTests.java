package com.green.nowon;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.green.nowon.domain.entity.CategoryEntity;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.domain.entity.ItemEntity;
import com.green.nowon.domain.entity.ItemEntityRepository;
import com.green.nowon.domain.entity.MyUserEntity;
import com.green.nowon.domain.entity.MyUserEntityRepository;
import com.green.nowon.security.MyRole;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpringSecurity6ProcApplicationTests {

	@Autowired
	private MyUserEntityRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	//@Test
	void admin계정생성() {
		
		repository.save(MyUserEntity.builder()
				.email("admin")
				.pass(encoder.encode("1111"))
				.nickName("관리자")
				.build()
					//return this 가 있으므로 계속 추가 세팅할 수 있음
					.addRole(MyRole.USER)
					.addRole(MyRole.SELLER)
					.addRole(MyRole.ADMIN)
				);
		
	}
	
	
	@Autowired
	CategoryEntityRepository cateRepo;
	
	//1차 카테고리 배열
	String[] fc = {"가구", "도서", "디지털/가전", "식품", "출산/육아", "패션의류"};
	
	//2차 카테고리 배열
	String[][] sc = {
			{"DIY자재/용품", "거실가구", "서재/사무용가구"},
			{"가정/요리", "건강/취미", "경제/경영"},
			{"PC", "PC부품", "노트북", "모니터", "생활가전", "휴대폰"},
			{"과자/베이커리", "김치", "농산물", "수산물", "축산물"},
			{"유아동의류", "유모차", "이유식"},
			{"남성의류", "여성의류", "남성언더웨어/잠옷", "여성언더웨어/잠옷"}
	};
	
	String[] farmArr = {"건과류", "견과류", "과일", "쌀", "잡곡/혼합곡", "채소"};
	String[] fruitArr = {"감", "감귤", "딸기", "레드향", "레몬", "망고", "매실", "멜론", "무화과", "바나나", "배", "복분자", "복숭아", "블루베리", "사과"};
	String[] arr1 = {"TV거실장", "소파", "장식장", "테이블"};
	String[] arr2 = {"거실테이블", "사이드테이블", "접이식테이블"};
	
	@Test
	void 카테고리입력_하위카테고리() {
		
		String pName = "테이블";
		String[] elements = arr2;
		
		CategoryEntity parent = cateRepo.findByName(pName).orElseThrow();
		
		for(String name : elements) {
			cateRepo.save(CategoryEntity.builder()
					.name(name)
					.parent(parent) //null이면 최상위 카테고리
					.build()
					);
		}
	}
	
	//@Test
	void 카테고리입력_2차() {
		
		List<String[]> list = Arrays.asList(sc);
		
		list.forEach(sArray -> {
			
			int i= list.indexOf(sArray);
			CategoryEntity parent = cateRepo.findByName(fc[i]).orElseThrow();
			
			Arrays.asList(sArray).forEach(name -> {
				cateRepo.save(CategoryEntity.builder()
						.name(name)
						.parent(parent)
						.build()
						);
			});
		});
		
		
		/*
		for(int i=0; i<fc.length; i++) {
			for(int j=0; j<sc[i].length; j++) {
				cateRepo.save(CategoryEntity.builder()
						.name(sc[i][j])
						.parent(cateRepo.findByName(fc[i]).orElseThrow())
						.build()
						);
			}
		}
		*/
		
	}
	
	//@Test
	void 카테고리입력_1차() {
		//asList: List 형식으로 변환해줌
		List<String> list = Arrays.asList(fc);
		
					//name 파라미터: list에 있는 문자열을 하나씩 가져옴
		list.forEach(name -> {
			cateRepo.save(CategoryEntity.builder()
					.name(name)
					.build()
					);
		});
	}
	
	//@Test
	void 카테고리입력테스트() {
		cateRepo.save(CategoryEntity.builder()
				.name("수산물")
				.build()
				);
		
		log.debug(">>> 카테고리 입력 성공");
	}
	
	
	@Autowired
	ItemEntityRepository itemRepo;
	
	//@Test
	void 카테고리적용_상품등록테스트() {
		itemRepo.save(ItemEntity.builder()
				.title("참외")
				.price(1000)
				.stock(100)
				.content("농산물 하위에 새로운 카테고리 생성")
				.build()
										//parent까지만 쓰고 파라미터로 null 넣어도 됨
				//.addCategory(cateRepo.findByNameAndParentIsNull("농산물").orElseThrow())
				//.addCategory(cateRepo.save(CategoryEntity.builder().name("이벤트").build())) //카테고리를 등록하면서 상품등록도 가능
				.addCategory(cateRepo.save(CategoryEntity.builder().name("참외").parent(cateRepo.findByName("농산물").orElseThrow()).build())) //하위 카테고리 생성하면서 상품등록
				);
		
		log.debug("상품+카테고리 등록");
	}
	
	
	//@Test
	void 삭제테스트() {
		//long a = 10;
		//Long b = 10L; //객체 형식은 형식이 일치해야 함

		//itemRepo.deleteById(1009L); //long 형식으로 변환해줘야 파라미터로 삽입 가능
		//또는 아래와 같이 표현 가능
		
		long no = 1008;
		itemRepo.deleteById(no);
		
		log.debug("상품 삭제: " + no);
		
	}

}
