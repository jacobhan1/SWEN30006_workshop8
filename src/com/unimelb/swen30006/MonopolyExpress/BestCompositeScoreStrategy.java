package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class BestCompositeScoreStrategy extends CompositeScoreStrategy implements ICalculateStrategy {

	@Override
	public int getScore(SquareSet squareSet) {
		int result = 0;
		for (ICalculateStrategy s : super.strategies) {
			int price = s.getScore(squareSet);
			result = Math.max(result, price);
		}
		return 0;
	}

}
