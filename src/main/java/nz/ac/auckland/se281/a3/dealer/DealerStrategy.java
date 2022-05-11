package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface DealerStrategy {

	/**
	 * This method would determine the action of the dealer whether it will hit or
	 * hold depending on the specified strategy
	 * 
	 * @param hand The hand of the dealer
	 * @return The action of the dealer in the form of either HIT or HOLD
	 */
	Action decideAction(Hand hand);

}
