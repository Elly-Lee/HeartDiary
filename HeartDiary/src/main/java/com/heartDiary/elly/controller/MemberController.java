package com.heartDiary.elly.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.heartDiary.elly.dto.Member;
import com.heartDiary.elly.model.ModelResult;
import com.heartDiary.elly.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// 로그인 페이지
	@RequestMapping("member/login")
	public String showMain() {
		return "member/login";
	}
	
	// 로그인 
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
			model.addAttribute("alertMsg", "HI :)");
			model.addAttribute("locationReplace", redirectUrl);
		}

		return "common/redirect";
	}
	
	// 로그아웃
	@RequestMapping("member/doLogout")
	public String doLogout(Model model, HttpSession session) {
		session.removeAttribute("loginedMemberId");
		
		model.addAttribute("locationReplace","/member/login");
		
		return "common/redirect";
	}
	
	// 회원가입 페이지
	@RequestMapping("member/join")
	public String showJoin() {
		System.out.println("doJoin page ");
		return "member/join";
	}
	
	// 회원가입
	@RequestMapping("member/doJoin")
	public String doJoin(Model model, @RequestParam Map<String,Object> param) {
		
		
		
		Map<String,Object> rs = memberService.join(param);
		
		String resultCode = (String)rs.get("resultCode");
		String msg = (String)rs.get("msg");
		
		model.addAttribute("alertMsg", msg);
		
		if(resultCode.startsWith("S-")) {
			String redirectUrl = "/member/login";
			model.addAttribute("locationReplace", redirectUrl);
		} else {
			model.addAttribute("historyBack", true);
		}
		
		return "common/redirect";
	}
	
	@RequestMapping(value="member/idCheck", method = RequestMethod.GET, produces ="application/json; charset=utf8")
	@ResponseBody
	public ModelResult idCheck(HttpServletRequest request) {
		//System.out.println("idCheck page ");
		String loginId = request.getParameter("loginId");
		
		ModelResult result = memberService.idCheck(loginId);
		//System.out.println("여기에러가있습니다요." + result.getMsg());
		Gson gson = new Gson();
		String resultStr = gson.toJson(result);
		
		
		//System.out.println("resultStr : " + resultStr);
		
		return result;
	}
}
