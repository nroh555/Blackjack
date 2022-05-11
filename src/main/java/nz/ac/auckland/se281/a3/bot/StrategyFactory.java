package nz.ac.auckland.se281.a3.bot;

public class StrategyFactory {

	/**
	 * This method uses the factory design pattern to create the strategies based on
	 * the input from the user
	 * 
	 * @param type the string which specifies which of the three strategies
	 * @return instantiate each of the respective strategy
	 */
	public static BotStrategy createStrategy(String type) {
		switch (type) {
		case "R":
			return new RandomStrategy();

		case "LR":
			return new LowRiskStrategy();

		case "HR":
			return new HighRiskStrategy();

		default:
			System.err.println("wrong strategy type");
			System.exit(0);
		}
		return null;
	}
}
