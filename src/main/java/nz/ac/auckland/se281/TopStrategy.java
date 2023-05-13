package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int aiFingers;
  private int aiSum;

  @Override
  public void runStrategy(int average, int mostPlayedFingers) {
    aiFingers = Utils.getRandomNumber(1, 5);
    aiSum = mostPlayedFingers + aiFingers;
    String aiFingersString = Integer.toString(aiFingers);
    String aiSumString = Integer.toString(aiSum);
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", aiFingersString, aiSumString);
  }

  @Override
  public int getFingers() {
    return aiFingers;
  }

  @Override
  public int getSum() {
    return aiSum;
  }
}
