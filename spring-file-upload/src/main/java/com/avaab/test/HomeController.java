package com.avaab.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST, params = "open", produces="text/*")	
	public @ResponseBody LinkedList<FileMeta> open(@RequestParam(value="open", required = false) String open, HttpServletResponse response, MultipartHttpServletRequest request, Model model) { 
		System.out.println("im here 111!!!");
		  //1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        StringBuilder fileContents = new StringBuilder();
        LinkedList<FileMeta> fileMetas = new LinkedList<FileMeta>();                
        //2. get each file
        while(itr.hasNext()){
            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());            
            FileMeta fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());            
            
            try {
               BufferedReader reader = new BufferedReader(new InputStreamReader(mpf.getInputStream()));
               for (String line; (line = reader.readLine()) != null;) {
            	   fileContents.append(line);
            	}            

           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           
           fileMeta.setContent(fileContents.toString()); 
           fileMetas.add(fileMeta);
        }
        
        response.setContentType("text/plain");
       // result will be string       
       return fileMetas;	

	}		
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST, params = "fileupload", produces="text/*")	
	public @ResponseBody LinkedList<FileMeta> upload2(@RequestParam(value="fileupload", required = false) String open, HttpServletResponse response, MultipartHttpServletRequest request, Model model) { 
		System.out.println("im here 222!!!");
		  //1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = null;
        StringBuilder fileContents = new StringBuilder();
        LinkedList<FileMeta> fileMetas = new LinkedList<FileMeta>();                
        //2. get each file
        while(itr.hasNext()){
            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());            
            FileMeta fileMeta = new FileMeta();
            fileMeta.setFileName(mpf.getOriginalFilename());
            fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
            fileMeta.setFileType(mpf.getContentType());            
            
            try {
               BufferedReader reader = new BufferedReader(new InputStreamReader(mpf.getInputStream()));
               for (String line; (line = reader.readLine()) != null;) {
            	   fileContents.append(line);
            	}            

           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
           
           fileMeta.setContent(fileContents.toString()); 
           fileMetas.add(fileMeta);
        }
        
        response.setContentType("text/plain");
       // result will be string       
       return fileMetas;	

	}		
	
	
}
