package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class OrangeStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName() == "200" && squareSet.countFilled() >= 3) {
			return 1800;
		}
		return 0;
	}

}
