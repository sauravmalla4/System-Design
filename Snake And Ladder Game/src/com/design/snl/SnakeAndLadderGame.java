package com.design.snl;

import com.design.snl.models.*;

import java.util.*;

public class SnakeAndLadderGame {
	private Board snlBoard;
	private Queue<Player> players;
	private boolean isGameOver;
	private int numberOfPlayers;
	
	public static int BOARD_SIZE=100;
	public static int NUMBER_OF_DICE=1;
	public static int NUMBER_OF_PLAYERS=2;
	
	public SnakeAndLadderGame(int boardSize){
		this.snlBoard=new Board(boardSize);
		this.players=new LinkedList<Player>();
		this.isGameOver=false;
		this.numberOfPlayers=SnakeAndLadderGame.NUMBER_OF_PLAYERS;
	}
	
	public void setPlayers(List<Player> players) {
		this.players=new LinkedList<Player>();
		this.numberOfPlayers=players.size();
		Map<String,Integer> playerPos=new HashMap<String,Integer>();
		for(Player player:players) {
			this.players.add(player);
			playerPos.put(player.getId(),0);
		}
		this.snlBoard.setPlayerPos(playerPos);
	}
	
	public void setSnakes(List<Snake> snakes) {
		this.snlBoard.setSnakes(snakes);
	}
	
	public void setLadders(List<Ladder> ladders) {
		this.snlBoard.setLadders(ladders);
	}
	
	public int newPosAfterSnakeOrLadder(int newPos) {
		int prev;
		do {
			prev=newPos;
			
			for(Snake snake:this.snlBoard.getSnakes()) {
				if(newPos==snake.getStart()) {
					newPos=snake.getEnd();
				}
			}
			
			for(Ladder ladder:this.snlBoard.getLadders()) {
				if(newPos==ladder.getStart()) {
					newPos=ladder.getEnd();
				}
			}
		}while(prev!=newPos);
		
		return newPos;
	}
	public void move(Player player,int pos) {
		int oldPos=this.snlBoard.getPlayerPos().get(player.getId());
		int newPos=oldPos+pos;
		int size=this.snlBoard.getSize();
		if(newPos>size) {
			newPos=oldPos;
		}
		else {
			newPos=newPosAfterSnakeOrLadder(newPos);
		}
		this.snlBoard.getPlayerPos().put(player.getId(), newPos);
		System.out.println("Player "+player.getName()+" Rolled and Moved to "+newPos+" Position");
	}
	
	public int rollTheDice() {
		return RollDice.roll();
	}
	
	public boolean hasPlayerWon(Player player) {
		int playerPosition=this.snlBoard.getPlayerPos().get(player.getId());
		return playerPosition==this.snlBoard.getSize();
	}
	
	public boolean isCompleted() {
		int numberOfPlayers=this.players.size();
		return numberOfPlayers< this.numberOfPlayers;
	}
	
	public void playGame() {
		while(!isCompleted()) {
			Player player=this.players.poll();
			int diceValue=rollTheDice();
			move(player,diceValue);
			if(hasPlayerWon(player)) {
				System.out.println("Player "+player.getName()+" has Won");
				this.players.remove(player);
			}
			else {
				this.players.add(player);
			}
		}
		this.isGameOver=true;
	}
	
	public boolean getGameStatus() {
		return this.isGameOver;
	}
}
