package com.heartDiary.elly.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.heartDiary.elly.dto.Member;
import com.heartDiary.elly.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
		
	@RequestMapping("member/login")
	public String showMain() {
		return "member/login";
	}
	
	@RequestMapping("/member/doLogin")
	public String doLogin(Model model, @RequestParam Map<String,Object> param, HttpSession session) {
		String loginId = (String) param.get("loginId");
		String loginPw = (String) param.get("loginPw");

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			model.addAttribute("alertMsg", "존재하지 않는 로그인 아이디 입니다.");
			model.addAttribute("historyBack", true);
		} else if (member.getLoginPw().equals(loginPw) == false) {
			model.addAttribute("alertMsg", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("historyBack", true);
		} else {
			session.setAttribute("loginedMemberId", member.getId());
			String redirectUrl = "/diary/list";
			model.addAttribute("alertMsg", "환영합니다.");
			model.addAttribute("locationReplace", redirectUrl);
		}

		return "common/redirect";
	}
	
}
