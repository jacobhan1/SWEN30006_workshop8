package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class RedStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName().equals("250") &&squareSet.countFilled() >= 3) {
			return 2200;
		}
		return 0;
	}

}
