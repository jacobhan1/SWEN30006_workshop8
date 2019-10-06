package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public class ScoreFactory {
	private static ScoreFactory factory;
	private BestCompositeScoreStrategy strategy = null;
	public static ScoreFactory getInstance() {
		if(factory == null) factory = new ScoreFactory();
		return factory;
	}
	
	public ICalculateStrategy getStrategy(SquareSet squareSet) {
		strategy = new BestCompositeScoreStrategy();
	
		strategy.add(new BrownStrategy());
		strategy.add(new DarkBlueStrategy());
		strategy.add(new GreenStrategy());
		strategy.add(new LightblueStrategy());
		strategy.add(new OrangeStrategy());
		strategy.add(new PinkStrategy());
		strategy.add(new RailroadsStrategy());
		strategy.add(new RedStrategy());
		strategy.add(new UtilitiesStrategy());
		strategy.add(new YellowStrategy());
		strategy.getScore(squareSet);
		return null;
	}
}
