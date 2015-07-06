package com.fragment.tests;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeControllerTwo {
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/fragment", method = RequestMethod.GET)
	public String homeTwo(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home2";
	}
	
	@PostConstruct
	public void test() {
		System.out.println(" FRAGMENT POST CONSTRUCT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}
	
}
