package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	protected int win = 0;
	protected int lose = 0;
	private boolean status;

	/**
	 * This constructor would instantiate the players which include human, bot1 and
	 * bot2
	 * 
	 * @param name the name of each of the players
	 */
	public Player(String name) {
		super(name);
	}

	/**
	 * This method would set the status of the player to true if the player wins the
	 * round
	 */

	public void setWin() {
		this.status = true;
	}

	/**
	 * This method would set the status of the player to false if the player loses
	 * the round
	 */

	public void setLose() {
		this.status = false;
	}

	/**
	 * This method would allow each of the players to make a bet between a range
	 * 
	 * @return the bet of each of the players
	 */
	public abstract int makeABet();

	/**
	 * This method would determine if the player won or lost at each round
	 * 
	 * @return the status of the player either win or lose
	 */
	public String getStatus() {
		if (status) {
			return " won";
		}
		return " lost";
	}
}
