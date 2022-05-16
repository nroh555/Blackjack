package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class StrategyRandom implements BotStrategy {

	@Override
	public Action decideAction(Hand hand) {
		// Returns a new random number between 1(inclusive) and 100(inclusive) each time
		if (new Random().nextInt(1, 101) < 50) {
			return Action.HOLD;
		}

		return Action.HIT;
	}

	@Override
	public int makeABet() {
		return new Random().nextInt(1, 101);
	}

}
