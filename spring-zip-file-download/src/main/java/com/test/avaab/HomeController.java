package com.test.avaab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(Locale locale, Model model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);

		String s = "hello world";
	    // set content attributes for the response
	    response.setContentType("application/zip");  
	    response.setHeader("Content-Disposition","inline; filename=output.zip;"); 

		ServletOutputStream outputStream = response.getOutputStream(); 
		try (ZipOutputStream zos = new ZipOutputStream(outputStream)) {

			ZipEntry entry = new ZipEntry("test.txt");

			zos.putNextEntry(entry);
			zos.write(s.getBytes());
			zos.closeEntry();
			zos.flush();
		    zos.close(); 
	        outputStream.flush();  
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} 

	}

}
