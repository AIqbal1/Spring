package com.ingg.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "croupier-console-details")
public class CroupierConsoleDetails
{
	private String colorHex;
	private String gameState;
	private String tableState;
	
	public CroupierConsoleDetails()
	{
		
	}
	
	public CroupierConsoleDetails(String colorHex, String gameState, String tableState)
	{		
		this.colorHex = colorHex;
		this.gameState = gameState;
		this.tableState = tableState;
	}	

	@XmlAttribute(name="background-colour")
	public String getColourHex()
	{
		return colorHex;
	}

	@XmlAttribute(name="current-event-state")
	public String getGameState()
	{
		return gameState;
	}

	@XmlAttribute(name="current-table-state")
	public String getTableState()
	{
		return tableState;
	}				
}