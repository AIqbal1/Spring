package com.iavaab.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/croupier")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * just return string as repsonse body!
	 * @param locale
	 * @param model
	 * @param ip
	 * @return
	 * @throws ChannelNotFoundException 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CroupierConsoleDetails> getTest(Locale locale, Model model, @RequestParam("ip") String ip) throws ChannelNotFoundException {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		throw new ChannelNotFoundException("rrrrr");
//		return new ResponseEntity<CroupierConsoleDetails>(new CroupierConsoleDetails("wewe","we","we"), HttpStatus.OK);		
	}	
	
	@ExceptionHandler(ChannelNotFoundException.class)
	@ResponseBody
	ResponseEntity<CroupierConsoleDetails> handleChannelNotFound(Exception e) 
	{		
//		LOGGER.error(e.getMessage(), e.getStackTrace());			
		return new ResponseEntity<CroupierConsoleDetails>(new CroupierConsoleDetails("wewe","we","we"), HttpStatus.NOT_FOUND);
	}
	
}
