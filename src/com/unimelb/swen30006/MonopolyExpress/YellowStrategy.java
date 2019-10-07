package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class YellowStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName().equals("300") && squareSet.countFilled() >= 3) {
			return 2700;
		}
		return 0;
	}

}
