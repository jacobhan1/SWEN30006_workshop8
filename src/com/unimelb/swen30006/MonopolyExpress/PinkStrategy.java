package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class PinkStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName().equals("150") && squareSet.countFilled() >= 3) {
			return 1500;
		}
		return 0;
	}

}
