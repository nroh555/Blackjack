package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	/**
	 * This method would determine the action of the bots whether it will hit or
	 * hold depending on the specified strategy
	 * 
	 * @param hand The hand of the bots
	 * @return the action of the bots in the form of either HIT or HOLD
	 */
	Action decideAction(Hand hand);

	int makeABet();

}
