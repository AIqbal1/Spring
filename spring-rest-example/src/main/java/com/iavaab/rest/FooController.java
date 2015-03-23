package com.iavaab.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {
	
	@RequestMapping(value= "/{channelId}/{gameCycleId}/state", method = RequestMethod.GET)
	@ResponseBody
	public GameCycleState getGameCycleState(@PathVariable("channelId") Integer channelId, @PathVariable("gameCycleId") Integer gameCycleId,		
																							HttpServletResponse response, HttpServletRequest request) {
		
		return new GameCycleState(1, "TEST");
		

	}
	

}
