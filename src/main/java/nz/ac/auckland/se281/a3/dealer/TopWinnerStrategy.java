package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class TopWinnerStrategy implements DealerStrategy {

	private Player topWinner;

	/**
	 * The constructor would instantiate the topWinnerStrategy. Note that the top
	 * winner must be decide first before the strategy is instantiated
	 * 
	 * @param topWinner The topWinner of the game
	 */
	public TopWinnerStrategy(Player topWinner) {
		this.topWinner = topWinner;
	}

	@Override
	public Action decideAction(Hand hand) {
		// The dealer still has a chance to beat the player so dealer would keep hitting
		// until the dealer has a score equal to the player
		if ((topWinner.getHand().getScore() < 21)
				|| (topWinner.getHand().getScore() == 21 && topWinner.getHand().getCards().size() > 2)) {

			if (hand.getScore() < this.topWinner.getHand().getScore()) {
				return Action.HIT;
			}

			else {
				return Action.HOLD;
			}
		}

		// The case when the player has gotten blackjack and the dealer can't win the
		// player anymore
		else if (this.topWinner.getHand().isBlackJack()) {
			if (hand.getScore() >= 17) {
				return Action.HOLD;
			}

			else {
				return Action.HIT;
			}
		}

		else if (this.topWinner.getHand().getScore() > 21) {
			// The dealer will hold if player is busted
			return Action.HOLD;
		}

		return null;
	}

}
