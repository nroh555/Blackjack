package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	protected int wins = 0;
	protected int lose = 0;
	private boolean status;

	public Player(String name) {
		super(name);
	}

	public void setWin() {
		this.status = true;
	}

	public void setLose() {
		this.status = false;
	}

	public abstract int makeABet();

	public String getStatus() {
		if (status) {
			return " won";
		}
		return " lost";
	}
}
