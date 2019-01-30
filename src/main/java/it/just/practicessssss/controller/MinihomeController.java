package it.just.practicessssss.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.just.practicessssss.dao.MinihitsDAO;
import it.just.practicessssss.dao.MinihomeDAO;
import it.just.practicessssss.vo.Minihits;
import it.just.practicessssss.vo.Minihome;

/**
 * 미니홈피 접근 및 미니 홈피 내부 객체들 교통정리용 컨트롤러
 * 
 * @author igorh
 *
 */
@Controller
public class MinihomeController {

	@Autowired
	MinihomeDAO home;
	@Autowired
	MinihitsDAO hits;

	private static final Logger logger = LoggerFactory.getLogger(MinihomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/minihome", method = RequestMethod.GET)
	public String home(int minih_seq, Model model, HttpSession session, HttpServletRequest req) {
		logger.info("Someone accessing No." + minih_seq + "Minihome, from " + req.getRemoteAddr());
		
		// 내용을 보내준다. 각 DB에서 내용을 가져온다.
		// 추가로 수정할 사항
		Minihome mhvo = null;
		ArrayList<String> mhitvo = null;
		mhvo = home.selectOne(minih_seq);
		int userid = mhvo.getUserid();
		mhitvo = hits.selectOne(userid);
		if ( mhvo != null )		model.addAttribute("mhvo", mhvo);
		if ( mhitvo != null )		model.addAttribute("mhitvo", mhitvo);
		
		// 접속자 정보를 확인하여 minihits db에 추가한다.
		int visitorid = 0;
		// login 관련 접속 merge하면 활성화
//		visitorid = Integer.parseInt((String)session.getAttribute("loginId"));
		if (visitorid == 0)			visitorid = userid;
	
		int reqResult = 0;
		reqResult = hits.insertOne(userid, visitorid);
		if ( reqResult == 0 ) logger.info("minihits DB 등록 실패: userid:" + userid + ", visitorid: " + visitorid);
		
		return "minihome";
	}
}
