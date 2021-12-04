package com.design.snl;

import com.design.snl.models.Snake;
import com.design.snl.models.Ladder;
import com.design.snl.models.Player;

import java.util.*;

public class Driver {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		int numberOfSnakes=scanner.nextInt();
		List<Snake> snakes=new ArrayList<Snake>();
		
		for(int i=0;i<numberOfSnakes;i++) {
			int start=scanner.nextInt();
			int end=scanner.nextInt();
			Snake snake=new Snake(start,end);
			snakes.add(snake);
		}
		
		int numberOfLadder=scanner.nextInt();
		List<Ladder> ladders=new ArrayList<Ladder>();
		
		for(int i=0;i<numberOfLadder;i++) {
			int start=scanner.nextInt();
			int end=scanner.nextInt();
			Ladder ladder=new Ladder(start,end);
			ladders.add(ladder);
		}
		
		int numberOfPlayer=scanner.nextInt();
		List<Player> players=new ArrayList<Player>();
		
		for(int i=0;i<numberOfPlayer;i++) {
			String name=scanner.nextLine();
			Player player=new Player(name);
			players.add(player);
		}
		
		int boardSize=scanner.nextInt();
		scanner.close();
		SnakeAndLadderGame snlGame=new SnakeAndLadderGame(boardSize);
		snlGame.setLadders(ladders);
		snlGame.setPlayers(players);
		snlGame.setSnakes(snakes);
		
		snlGame.playGame();
	}

}
