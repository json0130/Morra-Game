package nz.ac.auckland.se281;

public interface Strategy {
    public abstract void runStrategy(int average);

    public abstract int getFingers();

    public abstract int getSum();
}
