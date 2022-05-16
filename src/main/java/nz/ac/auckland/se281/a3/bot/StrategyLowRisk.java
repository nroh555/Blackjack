package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyLowRisk implements BotStrategy {

	@Override
	public Action decideAction(Hand hand) {
		if (hand.getScore() < 17) {
			return Action.HIT;
		}
		return Action.HOLD;
	}

	@Override
	public int makeABet() {
		// Returns a random integer between 10(inclusive) and 50(inclusive)
		return new Random().nextInt(10, 51);
	}
}
