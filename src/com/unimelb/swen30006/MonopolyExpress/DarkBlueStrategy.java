package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class DarkBlueStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName() == "500" && squareSet.countFilled() >= 2) {
			return 3500;
		}
		return 0;
	}

}
