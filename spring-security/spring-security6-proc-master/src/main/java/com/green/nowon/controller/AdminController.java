package com.green.nowon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.green.nowon.domain.dto.ItemImgSaveDTO;
import com.green.nowon.domain.dto.ItemSaveDTO;
import com.green.nowon.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final AdminService service;
	
	//private FileUploadUtil fileUploadUtil;
	
	@GetMapping("/admin")
	public String adminIndex() {
		return "admin/default";
	}
	
	@GetMapping("/admin/item")
	public String adminItem(Model model) {
		service.findAllProcess(model);
		return "admin/item/list";
	}
	/*
	@PostMapping("/admin/item")
	public String adminItem(ItemSaveDTO dto) {
		service.saveProcess(dto);
		return "redirect:/admin/item"; //get 요청
	}
	*/
	
	//이미지 여러개일 경우 배열로 저장하기
	@PostMapping("/admin/item")
	public String adminItem(Long[] categoryNo, ItemSaveDTO itemDto, ItemImgSaveDTO imgDto) {
		
		//System.out.println(">>>>>>>>>>> 카테고리 배열: " + Arrays.toString(categoryNo));
		
		//카테고리 값 가져오기: 가장 큰 숫자를 가져오면 그게 카테고리 값
		//셀프 조인이기 때문에 최 하위 카테고리 값이 가장 큰 값을 갖는 구조
		long maxNo = Arrays.asList(categoryNo).stream().max(Long::compareTo).get();
		
		//System.out.println(">>>>>>>>>>> 카테고리 값: "+maxNo);
		
		service.saveProcess(itemDto, imgDto, maxNo);
		
		return "redirect:/admin/item"; //get 요청
	}
	
	@GetMapping("/admin/item/new")
	public String adminItemNew() {
		return "admin/item/write";
	}
	
	//비동기 처리(페이지이동 X)
	@PostMapping("/admin/item/temp")
	@ResponseBody //뷰 이동이 아니라는 의미 ..?
	//map collection을 자동을 json 타입으로 변환해줌
	public ResponseEntity<Map<String, String>> tempUpload(MultipartFile tempImg){
		return ResponseEntity.ok().body(service.tempUpload(tempImg));
		//success: function(result){} >> result로 path 전달
	}
	
	@GetMapping("/admin/item/no")
	public String adminItemDetail(long no) {
		return "admin/item/detail";
	}
	
}
