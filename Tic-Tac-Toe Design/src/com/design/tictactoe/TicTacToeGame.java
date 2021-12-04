package com.design.tictactoe;

import com.design.tictactoe.models.*;

import java.util.*;

public class TicTacToeGame {
	private Grid grid;
	private Queue<Player> players;
	private int numberOfPlayers;
	
	public TicTacToeGame(){
		grid=new Grid();
		players=new LinkedList<Player>();
	}
	
	public void setPlayer(List<Player> players) {
		this.players=new LinkedList<Player>();
		this.numberOfPlayers=players.size();
		for(Player player:players) {
			this.players.add(player);
		}
		this.grid.setPlayers(players);
	}
	
	public Queue<Player> getPlayersQueue(){
		return this.players;
	}
	
	public void initializeGrid() {
		this.grid.initBoard();
	}
	
	public boolean isValidMove(Location loc) {
		return this.grid.getBoard()[loc.getX()][loc.getY()] == '_';
	}
	
	public void assignPiece(Location loc,char piece) {
		this.grid.setPiece(loc, piece);
	}
	
	public boolean rowCrossed() {
		for(int i=1;i<4;i++) {
			if(this.grid.getBoard()[i][1]==this.grid.getBoard()[i][2] && this.grid.getBoard()[i][2]==this.grid.getBoard()[i][3] && this.grid.getBoard()[i][1]!='_') {
				return true;
			}
		}
		return false;
	}
	
	public boolean columnCrossed() {
		for(int i=1;i<4;i++) {
			if(this.grid.getBoard()[1][i]==this.grid.getBoard()[2][i] && this.grid.getBoard()[2][i]==this.grid.getBoard()[3][i] && this.grid.getBoard()[1][i]!='_') {
				return true;
			}
		}
		return false;
	}
	
	public boolean diagonalCrossed() {
		if(this.grid.getBoard()[1][1]==this.grid.getBoard()[2][2] && this.grid.getBoard()[2][2]==this.grid.getBoard()[3][3] && this.grid.getBoard()[1][1]!='_') {
			return true;
		}
		
		if(this.grid.getBoard()[1][3]==this.grid.getBoard()[2][2] && this.grid.getBoard()[2][2]==this.grid.getBoard()[3][1] && this.grid.getBoard()[1][3]!='_') {
			return true;
		}
		return false;
	}
	
	public boolean isGameOver() {
		return this.rowCrossed() || this.columnCrossed() || this.diagonalCrossed();
	}
	
	public boolean makeMove(Player player,Location loc) {
		if(this.isValidMove(loc)==false) {
			return false;
		}
		this.grid.setPiece(loc, player.getPiece());
		return true;
	}
	
	public int getNumberOfPlayers() {
		return this.numberOfPlayers;
	}
	
	public void printBoard() {
		for(int i=1;i<4;i++) {
			for(int j=1;j<4;j++) {
				System.out.print(this.grid.getBoard()[i][j]+" ");
			}
			System.out.println();
		}
	}
}
