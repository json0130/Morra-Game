package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{

    int aiFingers;
    int aiSum;

    @Override
    public void runStrategy() {
        aiFingers = Utils.getRandomNumber(1,5);
        aiSum = Utils.getRandomNumber(1,10);
        MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", getFingers(), getSum());

    }

    @Override
    public String getFingers() {
        return Integer.toString(aiFingers);
    }

    @Override
    public String getSum() {
        return Integer.toString(aiSum);
    }

}
