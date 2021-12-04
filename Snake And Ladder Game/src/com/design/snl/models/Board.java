package com.design.snl.models;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
	private int size;
	private List<Snake> snakes;
	private List<Ladder> ladders;
	private Map<String,Integer> playerPos;
	
	
	public Board(int size) {
		this.size=size;
		snakes=new ArrayList<Snake>();
		ladders=new ArrayList<Ladder>();
		playerPos=new HashMap<String,Integer>();
	}
	
	public List<Ladder> getLadders(){
		return ladders;
	}
	
	public List<Snake> getSnakes(){
		return snakes;
	}
	
	public void setSnakes(List<Snake> snakes) {
		this.snakes=snakes;
	}
	
	public void setLadders(List<Ladder> ladders) {
		this.ladders=ladders;
	}
	
	public Map<String,Integer> getPlayerPos(){
		return playerPos;
	}
	
	public void setPlayerPos(Map<String,Integer> playerPos) {
		this.playerPos=playerPos;
	}
	
	public int getSize() {
		return size;
	}
}
