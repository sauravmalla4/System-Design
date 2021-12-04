package com.design.tictactoe.models;


public class Player {
	private String name;
	private char piece;
	
	public Player(String name,char piece) {
		this.name=name;
		this.piece=piece;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getPiece() {
		return this.piece;
	}
}
