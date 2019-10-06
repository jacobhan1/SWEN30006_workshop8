package com.unimelb.swen30006.MonopolyExpress;

import com.unimelb.swen30006.MonopolyExpress.Board.SquareSet;

public interface ICalculateStrategy {
	
	public int getScore(SquareSet squareSet);
}
