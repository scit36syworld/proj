package it.just.practicessssss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.just.practicessssss.dao.LoginfDAO;
import it.just.practicessssss.vo.Userinfo;

@Controller
public class loginController {
	
	@Autowired
	LoginfDAO ldao;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Userinfo uivo, HttpSession session, Model model) {
		System.out.println(uivo);
		String result = ldao.login(uivo);
		if(result==null || result=="") {
			model.addAttribute("userid",uivo.getUserid());
			return "home";
		}
		session.setAttribute("loginid", result);
		session.setAttribute("loginname", result);
		return "redirect:/";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃댐");
		return "redirect:/";
	}
}
