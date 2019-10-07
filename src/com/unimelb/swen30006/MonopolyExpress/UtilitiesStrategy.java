package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class UtilitiesStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName().equals("Utilities") && squareSet.countFilled() >= 2) {
			return 800;
		}
		return 0;
	}

}
