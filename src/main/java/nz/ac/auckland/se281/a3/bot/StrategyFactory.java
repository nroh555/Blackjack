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
		// If the user inputs R, this would instantiate the random strategy
		case "R":
			return new StrategyRandom();
		// If the user inputs LR, this would instantiate the low risk strategy
		case "LR":
			return new StrategyLowRisk();
		// If the user inputs HR, this would instantiate the high risk strategy
		case "HR":
			return new StrategyHighRisk();
		default:
			System.err.println("wrong strategy type");
			System.exit(0);
		}
		return null;
	}
}
