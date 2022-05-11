package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotStrategy;
import nz.ac.auckland.se281.a3.bot.StrategyFactory;
import nz.ac.auckland.se281.a3.dealer.Dealer;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private int[] scores = { 0, 0, 0 };
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * TODO This method initializes the Bots, you should change this method for
	 * Task1
	 */
	protected void initBots() {
		Bot bot1 = new Bot("Bot1");
		Bot bot2 = new Bot("Bot2");
		String botStrategyString = getBotStrategy(); // UNCOMMENT THIS
		players.add(bot1);
		players.add(bot2);

		// create and set Bots strategy here
		// Uses the factory design pattern to specify the desired strategy
		BotStrategy botStrategyOne = StrategyFactory.createStrategy(botStrategyString);
		BotStrategy botStrategyTwo = StrategyFactory.createStrategy(botStrategyString);
		bot1.setStrategy(botStrategyOne);
		bot2.setStrategy(botStrategyTwo);
	}

	/**
	 * TODO This method initializes the Dealer, you should change this method for
	 * Task2
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		this.dealer = new Dealer("Dealer");
		// The beginning of the game the dealer would target the highest bidder while
		// after it will target the top winner if net wins >= 2
		dealer.setHighestBidStrategy(players);

	}

	/**
	 * TODO This method prints and updates the results (wins and losses) you should
	 * change this method for Task 2 and Task 3
	 */
	protected void printAndUpdateResults(int round) {
		scores = scoreCard(this.players);
		dealer.decideIfChangeStrategy(decideTopWinner(), players, scores);

	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {
	}

	public Player decideTopWinner() {
		// This function should determine which player has more than 2 net-wins
		int desiredPos = 0;
		int maxNetWins = 0;
		for (int i = 0; i < scores.length; i++) {
			if ((scores[i] >= 2) && (scores[i] > maxNetWins)) {
				maxNetWins = scores[i];
				desiredPos = i; // Determines the position of the player with the most netwins
			}
		}

		return players.get(desiredPos);
	}

	public int[] scoreCard(List<Player> players) {
		int index = 0;
		for (Player p : players) {
			// The case when the player gets BlackJack and the dealer does not
			if (p.getHand().isBlackJack() && dealer.getHand().getCards().size() > 2) {
				p.wins++;
				p.setWin();
				scores[index] = scores[index] + 1;
			}

			// The case when the player's hand is greater than the dealer's hand and the
			// player is not busted
			else if ((dealer.getHand().getScore() < p.getHand().getScore()) && (p.getHand().getScore() <= 21)) {
				p.wins++;
				p.setWin();
				scores[index] = scores[index] + 1;
			}

			// The case when the dealer is busted and the players are not
			else if (p.getHand().getScore() <= 21 && dealer.getHand().getScore() > 21) {
				p.wins++;
				p.setWin();
				scores[index] = scores[index] + 1;
			}

			// All losing cases
			else {
				p.lose++;
				p.setLose();
				scores[index] = scores[index] - 1;
			}

			index++;
		}

		return scores;
	}

}
