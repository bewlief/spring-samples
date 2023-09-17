package com.green.nowon.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.green.nowon.domain.dto.CategoryListDTO;
import com.green.nowon.domain.entity.CategoryEntityRepository;
import com.green.nowon.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceProcess implements CategoryService {

	private final CategoryEntityRepository repo;
	
	//아래 메소드가 모두 처리.. 이제 사용하지 않음
	@Override
	public List<CategoryListDTO> getCategoryProcess() {
		return repo.findAllByParent(null).stream()
				.map(CategoryListDTO::new)
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryListDTO> getCategoryProcess(long no) {
											//id를 통한 값이 존재하지 않으면 예외처리 대신 null값 출력
		return repo.findAllByParent(repo.findById(no).orElse(null)).stream()
				.map(CategoryListDTO::new)
				.collect(Collectors.toList());
		
		
		//이렇게 작성해도 됨
		/*
		if(no==0) { //1차 카테고리 분류 출력
			return repo.findAllByParent(null).stream()
					.map(CategoryListDTO::new)
					.collect(Collectors.toList());
		} else {
			return repo.findAllByParentNo(no).stream() //findAllByParent_no로 작성해도 허용함
					.map(CategoryListDTO::new)
					.collect(Collectors.toList());
		}
		*/
	}

}
