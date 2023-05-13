package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public abstract class Player {

  public static Jarvis createAi(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        return new Easy();
      case MEDIUM:
        return new Medium();
      case HARD:
        return new Hard();
      case MASTER:
        return new Master();
      default:
        return null;
    }
  }
}
