package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class TopWinnerStrategy implements DealerStrategy {

	private Player topWinner;

	public TopWinnerStrategy(Player topWinner) {
		this.topWinner = topWinner;
	}

	@Override
	public Action decideAction(Hand hand) {
		// The dealer still has a chance to beat the player
		if (this.topWinner.getHand().getScore() < 21) {
			if (hand.getScore() < this.topWinner.getHand().getScore()) {
				return Action.HIT;
			}

			else {
				return Action.HOLD;
			}
		}

		// The case when the player has gotten blackJack and the dealer can't win the
		// player
		else if (this.topWinner.getHand().getScore() == 21) {
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
