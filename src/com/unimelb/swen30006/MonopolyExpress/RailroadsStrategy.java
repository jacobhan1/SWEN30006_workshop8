package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class RailroadsStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		if (squareSet.getGroupName() == "Railroads" && squareSet.countFilled() >= 4) {
			return 2500;
		}
		return 0;
	}

}
