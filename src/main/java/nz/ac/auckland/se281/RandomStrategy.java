package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy{

    int aiFingers;
    int aiSum;

    @Override
    public void runStrategy() {
        aiFingers = Utils.getRandomNumber(1,5);
        aiSum = Utils.getRandomNumber(aiFingers + 1,aiFingers + 5);
        
        MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));
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
