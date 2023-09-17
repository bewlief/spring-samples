package com.green.nowon.service;

import java.util.List;

import com.green.nowon.domain.dto.CategoryListDTO;

public interface CategoryService {

	//아래 메소드가 모두 처리.. 이제 사용하지 않음
	List<CategoryListDTO> getCategoryProcess();

	List<CategoryListDTO> getCategoryProcess(long no);

}
