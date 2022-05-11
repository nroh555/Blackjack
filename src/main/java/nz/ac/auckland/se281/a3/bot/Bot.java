package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	private BotStrategy strategy;

	public Bot(String name) {
		super(name);
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.decideAction(hand);
	}

	@Override
	public int makeABet() {
		return strategy.makeABet();
	}

	public BotStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(BotStrategy strategy) {
		this.strategy = strategy;
	}

}
