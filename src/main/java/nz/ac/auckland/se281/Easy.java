package nz.ac.auckland.se281;

public class Easy implements Jarvis {

    private Strategy strategy;

    @Override
    public void runStrategy(int average) {
        Strategy strategy = new RandomStrategy();
        this.strategy = strategy;
        strategy.runStrategy(average);
    }

    @Override
    public int getFingers() {
        return strategy.getFingers();
    }

    @Override
    public int getSum() {
        return strategy.getSum();
    }   
}
