/**
 * This class is for Workshop's exercises for SWEN30006 Software Design and Modelling subject at the University of Melbourne
 * @author 	Patanamon Thongtanunam
 * @version 1.0
 * @since 	2019-04
 * 
 */

package com.unimelb.swen30006.MonopolyExpress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.unimelb.swen30006.MonopolyExpress.Board.BoardGame;
import com.unimelb.swen30006.MonopolyExpress.Dice.*;



public class MonopolyExpress {

	public static void main(String[] args) {
		
		BoardGame board = new BoardGame();
		
		ArrayList<Player> players = new ArrayList<Player>();
		 
		players.add(new Player("A"));
		players.add(new Player("B"));
		
		Scanner in = new Scanner(System.in);
		
		boolean hasWinner = false;
		
		while(!hasWinner) {
			Player currentPlayer = players.remove(0);
			System.out.println("====== "+currentPlayer.getName()+"'s turn ====");
			
			boolean turnEnds = false;
			do {
				//Roll the dice and show the faces
				board.rollDice();
				System.out.println("Police Dice: " + board.getPoliceDiceName());
				System.out.println("Number Dice: " + board.getNumberDiceName()); 
				//Check PoliceDice and place on the board
				for (Die d : board.dies) {
					if (d instanceof DiePolice) {
						board.placeDie(d);
					}
				}
				
				System.out.println(board.show());
				
				if(board.isAllFilled("Police")) {
					break;
				}else {
					//Ask the player to pick the number dice
					// remove placed police.
					Iterator<Die> iter = board.dies.iterator();
					while (iter.hasNext() ) {
						if (iter.next().getCurrentFaceName().equals("Police")) {
							iter.remove();
						}
					}
					int index = 0;
					
					
					do {
						System.out.println("------ Remaining Dice ----");
						//show dice faces
						System.out.println("Police Dice: " + board.getPoliceDiceName());
						System.out.println("Number Dice: " + board.getNumberDiceName());
						int remainingDice = board.numberDice.size();
						System.out.print("["+currentPlayer.getName()+"]Pick a number die (1-"+remainingDice+") or -1 (no pick):");
						index = in.nextInt();
						if(index >= 1 && index <= remainingDice) {
							board.placeDie(board.getNumberDie(index));
							board.dies.remove(board.getNumberDie(index));
						}				
					}while(index != -1);
					
					
					System.out.print("["+currentPlayer.getName()+"] Keep rolling? (y/n):");
					String answer = in.next();
					
					if(answer.toLowerCase().equals("n")) {
						turnEnds = true;
					}
				}	
	
			}while(!turnEnds);
			System.out.println("Turn ends");
			
			
			
			//Calculate score
			
			
			players.add(currentPlayer);
			board.reset();
		}
		
		in.close();
		
	}

	
	
}
