package com.ingg.rest;

public class GameCycleState {
	private int id;
	
	private String state;

	public GameCycleState(int id, String state) {
		super();
		this.id = id;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public String getState() {
		return state;
	}
	
	
}
