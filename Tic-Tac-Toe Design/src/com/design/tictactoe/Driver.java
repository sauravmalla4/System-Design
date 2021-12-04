package com.design.tictactoe;

import com.design.tictactoe.models.*;


import java.util.*;


public class Driver {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter the Number Of Players");
		int numberOfPlayers=scanner.nextInt();
		List<Player> players=new ArrayList<Player>();
		scanner.nextLine();
		for(int i=0;i<numberOfPlayers;i++) {
			System.out.println("Enter the Name Of Player "+(i+1));
			String name=scanner.nextLine();
			System.out.println("Enter the Piece Of "+(i+1)+"th Player like X, O");
			char piece=scanner.nextLine().charAt(0);
			Player player=new Player(name,piece);
			players.add(player);
		}
		
		TicTacToeGame game=new TicTacToeGame();
		
		game.initializeGrid();
		game.setPlayer(players);
		int moveCount=0;
		Player winner=null;
		while(game.isGameOver()==false && moveCount<9) {
			Player player=game.getPlayersQueue().poll();
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			Location loc=new Location(x,y);
			while(game.makeMove(player, loc)==false) {
				System.out.println("This is an invalid Move, Please Enter Location Again");
				x=scanner.nextInt();
				y=scanner.nextInt();
				loc=new Location(x,y);
			}
			System.out.println("Move Successful");
			System.out.println("The Current Status OF Board is:-");
			game.printBoard();
			winner=player;
			game.getPlayersQueue().add(player);
			moveCount++;
		}
		if(moveCount>=9) {
			System.out.println("Match Draw");
		}
		else if(winner!=null){
			System.out.println("The Winner Of the Game is "+ winner.getName());
		}
		else {
			System.out.println("Invalid Game");
		}
		System.out.println("========Game Finished==========");
		scanner.close();
	}
}
