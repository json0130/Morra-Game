package nz.ac.auckland.se281;

public interface Strategy {
    public abstract void runStrategy(int average,int mostPlayedFingers);

    public abstract int getFingers();

    public abstract int getSum();
}
