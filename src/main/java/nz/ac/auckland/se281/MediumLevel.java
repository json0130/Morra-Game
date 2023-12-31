package nz.ac.auckland.se281;

public class MediumLevel implements Jarvis {

  private Strategy strategy;
  private int round;

  @Override
  public void runStrategy(int average, int round, int mostPlayedFingers) {
    Strategy strategy = new RandomStrategy();
    this.round = round;
    this.strategy = strategy;
    setStrategy(changeStrategy());
    this.strategy.runStrategy(average, mostPlayedFingers);
  }

  @Override
  public int getFingers() {
    return strategy.getFingers();
  }

  @Override
  public int getSum() {
    return strategy.getSum();
  }

  public Strategy changeStrategy() {
    if (round - 1 >= 4 && this.strategy instanceof RandomStrategy) {
      strategy = new AverageStrategy();
    }
    return strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
