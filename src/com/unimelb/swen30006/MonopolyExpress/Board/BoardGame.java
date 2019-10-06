/**
 * This class is for Workshop's exercises for SWEN30006 Software Design and Modelling subject at the University of Melbourne
 * @author 	Patanamon Thongtanunam
 * @version 1.0
 * @since 	2019-04
 * 
 */

package com.unimelb.swen30006.MonopolyExpress.Board;

import java.util.ArrayList;
import com.unimelb.swen30006.MonopolyExpress.Dice.*;


public class BoardGame {
	private ArrayList<SquareSet> groups;
	public ArrayList<Die> dies;
	private ArrayList<String> policeDice = new ArrayList<>();
	private ArrayList<String> numberDice = new ArrayList<>();
	public BoardGame() {
		this.groups = new ArrayList<SquareSet>();
		this.dies = new ArrayList<>();
		dies.add(new Die1());
		dies.add(new Die1());
		dies.add(new Die34());
		dies.add(new Die34());
		dies.add(new Die5());
		dies.add(new DieUtility());
		dies.add(new DieUtility());
		dies.add(new DiePolice());
		dies.add(new DiePolice());
		dies.add(new DiePolice());
		
		reset();
	}
	
	public void reset() {
		if(this.groups.size() > 0) {
			this.groups.clear();
		}
		groups.add(new SquareSet("Police", 3));
		groups.add(new SquareSet("Utility", 2));
		groups.add(new SquareSet("Railroad", 4));
		groups.add(new SquareSet("50", 2));
		groups.add(new SquareSet("100", 3));
		groups.add(new SquareSet("150", 3));
		groups.add(new SquareSet("200", 3));
		groups.add(new SquareSet("250", 3));
		groups.add(new SquareSet("300", 3));
		groups.add(new SquareSet("400", 3));
		groups.add(new SquareSet("500", 2));
	}
	
	public void rollDice () {
		for (Die die : dies) {
			die.roll();
			if (die instanceof DiePolice) {
				policeDice.add(die.getCurrentFaceName());
			} else {
				numberDice.add(die.getCurrentFaceName());
			}
		}
	}
	public void placeDie(Die d) {
		String selectedGroup = d.getCurrentFaceName();
		for(int i = 0; i < groups.size(); i++) {
			if(groups.get(i).getGroupName().equals(selectedGroup)) {
				groups.get(i).place(d);
			}
		}
	}
	
	public String show() {
		String output = "======= BOARD =====\n";
		for(SquareSet ss : groups) {
			output += ss.showSquares()+"\n";
		}
		output += "=============";
		return output;
	}
	
	public ArrayList<SquareSet> getCompleteGroup(){
		ArrayList<SquareSet> complete = new ArrayList<SquareSet>();
		for(SquareSet ss: groups) {
			if(ss.isAllFilled()) {
				complete.add(ss);
			}
		}
		return(complete);
	}
	
	public ArrayList<SquareSet> getInCompleteGroup(){
		ArrayList<SquareSet> incomplete = new ArrayList<SquareSet>();
		for(SquareSet ss: groups) {
			if(!ss.isAllFilled()) {
				incomplete.add(ss);
			}
		}
		return(incomplete);
	}
	
	public boolean isAllFilled(String face) {
		boolean allFilled = false;
		for(SquareSet ss: groups) {
			if(ss.getGroupName().equals(face)) {
				allFilled = ss.isAllFilled();
			}
		}
		
		return allFilled;
	}

	public String getPoliceDiceName() {
		String result = "";
		for (String s : policeDice) {
			result += s + " | ";
		}
		return result;
	}

	public String getNumberDiceName() {
		String result = "";
		for (String s : numberDice) {
			result += s + " | ";
		}
		return result;
	}

	public void resetDice() {
		policeDice.clear();
		numberDice.clear();
	}
	
	public String getRemainPolice () {
		int size = 0;
		for (String s : policeDice) {
			if (s.equals("<blank>")) {
				size++;
			}
		}
		String remainPolice = "";
		for (int i = 0; i < size; i++) {
			remainPolice += "<blank>" + " | ";
		}
		return remainPolice;
	}

}
