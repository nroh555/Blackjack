package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class HighestBidStrategy implements DealerStrategy {

	private List<Player> players;

	/**
	 * The constructor would instantiate the highestBidStrategy
	 * 
	 * @param players The players of the game
	 */
	public HighestBidStrategy(List<Player> players) {
		this.players = players;
	}

	@Override
	public Action decideAction(Hand hand) {
		int maxBet = 0;
		int desiredPos = 0;
		int index = 0;
		for (Player player : players) {
			if (player.getHand().getBet() > maxBet) {
				maxBet = player.getHand().getBet();
				desiredPos = index; // Determines the position of the player with the highest bidder
			}
			index++;
		}

		// The dealer still has a chance to beat the player so it will keep hitting
		// until it
		// has a hand greater than the desired player or busted
		if ((this.players.get(desiredPos).getHand().getScore() < 21)
				|| (this.players.get(desiredPos).getHand().getScore() == 21
						&& this.players.get(desiredPos).getHand().getCards().size() > 2)) {
			if (hand.getScore() < this.players.get(desiredPos).getHand().getScore()) {
				return Action.HIT;
			}

			else {
				return Action.HOLD;
			}
		}

		// The case when the player has gotten blackjack and the dealer can't win the
		// player
		else if (this.players.get(desiredPos).getHand().isBlackJack()) {
			if (hand.getScore() >= 17) {
				return Action.HOLD;
			}

			else {
				return Action.HIT;
			}
		}

		// The dealer will hold if player is busted
		else if (this.players.get(desiredPos).getHand().getScore() > 21) {
			return Action.HOLD;
		}

		return null;
	}
}
