package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Player {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void runStrategy() {
        strategy.runStrategy();
    }

    public Player getStrategy(Difficulty difficulty) {
        // Get the strategy based on the difficulty
        switch (difficulty) {
            case EASY:
                setStrategy(new RandomStrategy());
                return this;
            case MEDIUM:
                setStrategy(new AverageStrategy());
                return this;
            case HARD:
                setStrategy(new TopStrategy());
                return this;
            default:
                return null;
        }
    }
    
}
