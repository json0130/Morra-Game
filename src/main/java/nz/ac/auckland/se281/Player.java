package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public abstract class Player {

  public static Jarvis createAi(Difficulty difficulty) {
    // This method creates an instance of the Jarvis interface based on the difficulty
    switch (difficulty) {
      case EASY:
        return new EasyLevel();
      case MEDIUM:
        return new MediumLevel();
      case HARD:
        return new HardLevel();
      case MASTER:
        return new MasterLevel();
      default:
        return null;
    }
  }
}
