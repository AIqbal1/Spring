package com.iavaab.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iavaab.mcc.server.pit.form.ChannelForm;
import com.iavaab.server.pit.springconfiguration.ChannelData;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/pit")
public class PitController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PitController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	private static final String VIEW_NAME = "channels";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Get loaded channels");
		try{
			// get the data for the page
			model.addAttribute("channelDataList", getCurrentChannels());		
			model.addAttribute("channelForm", new ChannelForm());
			// load the page
			return VIEW_NAME;		
		} catch(Exception e) {
			throw new HttpMessageNotWritableException("Server not ready", e);
		}
	}
	
	private List<ChannelData> getCurrentChannels() {
		LOGGER.debug("Create channel information objects for pit form");
		List<ChannelData> currentChannels = new ArrayList<ChannelData>();
		
		for (int i=0; i<2; i++) {
			ChannelData loadedChannel = new ChannelData();			
			loadedChannel.setChannelId(1);
			loadedChannel.setChannelName("VIRTUAL HORSE" + i);
			loadedChannel.setTableState("OPEN");
			loadedChannel.setEventState("PLACE_BETS");
			currentChannels.add(loadedChannel);
			
		}
				
		return currentChannels;
	}	
	
}
