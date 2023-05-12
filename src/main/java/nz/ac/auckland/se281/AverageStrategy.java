package nz.ac.auckland.se281;

public class AverageStrategy implements Strategy {

    int aiFingers;
    int aiSum;

    @Override
    public void runStrategy(int average,int mostPlayedFingers) {
        aiFingers = Utils.getRandomNumber(1,5);
        aiSum = average + aiFingers;
         //average of player's fingers + aiFingers
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
