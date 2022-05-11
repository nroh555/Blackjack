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

	public Dealer(String name) {
		super(name);
	}

	public DealerStrategy getStrategy() {
		return strategy;
	}

	public void setHighestBidStrategy(List<Player> players) {
		this.strategy = new HighestBidStrategy(players);
	}

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
