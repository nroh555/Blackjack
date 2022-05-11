package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {

	private DealerStrategy strategy;

	/**
	 * This constructor would instantiate the dealer
	 * 
	 * @param name The name of the dealer
	 */
	public Dealer(String name) {
		super(name);
	}

	public DealerStrategy getStrategy() {
		return strategy;
	}

	/**
	 * This method would set the current strategy to the highest bidder strategy
	 * 
	 * @param players The players of the blackjack game
	 */
	public void setHighestBidStrategy(List<Player> players) {
		this.strategy = new HighestBidStrategy(players);
	}

	/**
	 * This method would decide if the dealer's strategy should be changed to
	 * TopWinner if the net wins of any of the player is greater or equal to 2.
	 * Otherwise, the strategy would remain to be highestBidder
	 * 
	 * @param topWinner The topWinner of the game if there exist one
	 * @param players   The players of the blackjack game
	 * @param scores    The scores of each of the player
	 */
	public void decideIfChangeStrategy(Player topWinner, List<Player> players, int[] scores) {
		if (scores[0] >= 2 || scores[1] >= 2 || scores[2] >= 2) {
			this.strategy = new TopWinnerStrategy(topWinner);
		}

		else {
			this.strategy = new HighestBidStrategy(players);
		}
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.decideAction(hand);
	}
}
