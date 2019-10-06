package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class ScoreFactory {
	private static ScoreFactory factory;
	private ICalculateStrategy strategy = null;
	public static ScoreFactory getInstance() {
		if(factory == null) factory = new ScoreFactory();
		return factory;
	}
	
	public ICalculateStrategy getStrategy(SquareSet squareSet) {
		strategy = new BestCompositeScoreStrategy();
		return null;
	}
}
