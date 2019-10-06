package com.unimelb.swen30006.MonopolyExpress;


import java.util.ArrayList;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public abstract class CompositeScoreStrategy implements ICalculateStrategy {
	protected ArrayList<ICalculateStrategy> strategies = new ArrayList<> ();
	
	public void add (ICalculateStrategy s) {
		strategies.add(s);
	}
	@Override
	public abstract int getScore(SquareSet squareSet);

}
