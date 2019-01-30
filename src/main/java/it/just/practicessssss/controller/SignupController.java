package it.just.practicessssss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.just.practicessssss.dao.SignupDAO;
import it.just.practicessssss.vo.Userinfo;

@Controller
public class SignupController {

	@Autowired
	SignupDAO sdao;
	
	//회원가입 창열기
	@RequestMapping(value="signup", method=RequestMethod.GET)
	public String signupForm() {
		return "signup";
	}
	
	//회원가입 창열기
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String signup(Userinfo uivo, Model model) {
		int result = sdao.insertUserinfo(uivo);
		
		if(result<1) {
			model.addAttribute("uivo", uivo);
			model.addAttribute("msg", "오류 : 가입실패 <br>필수 입력정보를 확인해주세요");
			return "signup";
		}
		return "redirect:/";
	}
	
	//idcheck 창열기
	@RequestMapping(value="idCheck", method=RequestMethod.GET)
	public String idCheckForm() {
		return "idcheck";
	}
	
	/*
	 * idcheck 실행 
	 * 0반환시 사용가능
	 * 1반환시 사용불가
	 * */	
	@RequestMapping(value="idChecker", method=RequestMethod.POST)
	public String idChecker(String userid, Model model) {
		int result = sdao.idcheck(userid);
		model.addAttribute("userid", userid);
		if(result>0) {
			model.addAttribute("msg", "중복된 아이디가 잇습니다.");
		}
		model.addAttribute("result", true);
		return "idcheck";
	}
	
}
