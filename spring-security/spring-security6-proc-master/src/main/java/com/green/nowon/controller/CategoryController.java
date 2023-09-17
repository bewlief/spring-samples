package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.green.nowon.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/common/")
@Controller
public class CategoryController {
	
	private final CategoryService service;
	
	//ModelAndView: 해당하는 html을 그대로 리턴 >> category/list
	@ResponseBody //ajax 사용시 필요
	@GetMapping("category")
	public ModelAndView category() {
		ModelAndView mv = new ModelAndView("category/list");
		mv.addObject("list", service.getCategoryProcess());
		return mv;
	}
	
	//아래 메소드로 통합.. 이제 사용하지 않음
	@ResponseBody //ajax 사용시 필요
	@GetMapping("category-select")
	public ModelAndView categorySelect() {
		ModelAndView mv = new ModelAndView("category/list-select");
		mv.addObject("list", service.getCategoryProcess());
		return mv;
	}
	
	@ResponseBody //ajax 사용시 필요
	@GetMapping("category-select/{no}")
	public ModelAndView categorySelect(@PathVariable long no) {
		ModelAndView mv = new ModelAndView("category/list-select");
		mv.addObject("list", service.getCategoryProcess(no));
		return mv;
	}
	
	@GetMapping("category/{no}")
	public void detail(long no, Model model) {
		
	}
	
}
