package it.just.practicessssss;

import java.text.DateFormat;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home";
	}

	@RequestMapping(value = "gogo", method = RequestMethod.GET)
	public String gogo(int num, Model model) {
		model.addAttribute("num", num);
		
		try {
			
		} catch (DuplicateFormatFlagsException e) {
			// TODO: handle exception
		}
		
		if(num==1) {
			return "redirect:/";
			
		}
		if(num==2) {
			return "redirect:gogo";
		}
		if(num==3) {
			return "redirect:gogo2";
		}
		if(num==4) {
			return "redirect:/practicessssss/gogo";
		}
		if(num==5) {
			return "redirect:/gogo";
		}
		
		return "page1";
	}
	@RequestMapping(value = "gogo2", method = RequestMethod.GET)
	public String gogo2(int num, Model model) {
		model.addAttribute("num", num);
		
		
		return "page2";
	}
}
