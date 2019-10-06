package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class LightblueStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName() == "100" && squareSet.countFilled() >= 3) {
			return 1000;
		}
		return 0;
	}

}
