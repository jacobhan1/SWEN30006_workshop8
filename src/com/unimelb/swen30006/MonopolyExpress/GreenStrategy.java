package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class GreenStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName() == "400" && squareSet.countFilled() >= 3) {
			return 3000;
		}
		return 0;
	}

}
