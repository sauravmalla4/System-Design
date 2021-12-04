package com.design.tictactoe.models;

import java.util.*;

public class Grid {
	private char[][] board;
	private List<Player> players;
	
	public Grid() {
		board=new char[4][4];
		players=new ArrayList<Player>();
	}
	
	public void initBoard() {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				this.board[i][j]='_';
			}
		}
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void setPlayers(List<Player> players) {
		this.players=players;
	}
	
	public void setPiece(Location loc,char piece) {
		this.board[loc.getX()][loc.getY()]=piece;
	}
	
	public List<Player> getPlayer(){
		return this.players; 
	}
	
	public char[][] getBoard(){
		return this.board;
	}
	
}
