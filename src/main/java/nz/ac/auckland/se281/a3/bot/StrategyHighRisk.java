package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyHighRisk implements BotStrategy {

	@Override
	public Action decideAction(Hand hand) {
		if (hand.getScore() < 19) {
			return Action.HIT;
		}

		return Action.HOLD;
	}

	@Override
	public int makeABet() {
		// Returns a random integer between 50(inclusive) and 100(inclusive)
		return new Random().nextInt(50, 101);
	}

}
