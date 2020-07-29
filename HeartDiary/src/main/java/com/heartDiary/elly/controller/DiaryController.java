package com.heartDiary.elly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.heartDiary.elly.dto.Diary;
import com.heartDiary.elly.service.DiaryService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping("/diary/list")
	public String showList(Model model) {
		List<Diary> diaries = diaryService.getDiaries();
		
		model.addAttribute("diaries", diaries);
		
		return "diary/list";		
	}
	
}
