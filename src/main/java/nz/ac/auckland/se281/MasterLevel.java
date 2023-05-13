package nz.ac.auckland.se281;

public class MasterLevel implements Jarvis {

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
    // It changes the strategy after round 3 and alternates between AverageStrategy and TopStrategy
    if (round - 1 == 4 && this.strategy instanceof RandomStrategy) {
      strategy = new AverageStrategy();
    } else if ((round - 1) % 2 == 0 && round - 1 >= 4) {
      strategy = new AverageStrategy();
    } else if ((round - 1) % 2 != 0 && round - 1 >= 4) {
      strategy = new TopStrategy();
    }
    return strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}
