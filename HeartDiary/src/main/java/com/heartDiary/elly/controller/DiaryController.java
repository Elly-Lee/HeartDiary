package com.heartDiary.elly.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/diary/detail")
	public String showDetail(Model model, int id) {
		Diary diary = diaryService.getDiary(id);
		
		model.addAttribute("diary", diary);
		
		return "diary/detail";
	}
	
	// 일기 추가 페이지
	@RequestMapping("/diary/write")
	public String showWrite(Model model) {
		return "diary/write";
	}
	
	// 일기 추가 기능
	@RequestMapping("/diary/doWrite")
	public String doWrite(Model model, @RequestParam Map<String,Object> param) {
		Map<String,Object> data = diaryService.write(param);
		
		String msg = (String)data.get("msg");
		String redirectUrl = "/diary/list";
		
		model.addAttribute("alertMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return "common/redirect";		
	}
	// 삭제 기능
	@RequestMapping("/diary/doDelete")
	public String doDelete(Model model, int id) {
		Map<String,Object> data = diaryService.deleteDiary(id);
		
		String msg = (String)data.get("msg");
		String redirectUrl = "/diary/list";
		
		model.addAttribute("alertMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return "common/redirect";
	}
	
	// 수정 페이지 
	@RequestMapping("/diary/modify")
	public String showModify(Model model, int id) {
		Diary diary = diaryService.getDiary(id);
		
		model.addAttribute("diary", diary);
		
		return "diary/modify";
	}
	
	// 게시글 수정 기능
	@RequestMapping("/diary/doModify")
	public String doModify(Model model, @RequestParam Map<String,Object> param) {
		Map<String,Object> data = diaryService.modifyDiary(param);
		
		int id = Integer.parseInt((String) param.get("id"));
		
		String msg = (String) data.get("msg");
		String redirectUrl = "/diary/detail?id=" + id;
		
		model.addAttribute("alertMsg", msg);
		model.addAttribute("locationReplace", redirectUrl);
		
		return "common/redirect";	
		
	}
	
	
}
