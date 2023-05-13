package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String input;
  private String fingers;
  private String sum;
  private String player;
  private int i = 1;
  private int playerWon = 0;
  private int aiWon = 0;
  private Difficulty difficulty;
  private int pointsToWin;
  private boolean gameStarted = false;

  private ArrayList<Integer> playerFingerList = new ArrayList<Integer>();

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    this.difficulty = difficulty;
    this.pointsToWin = pointsToWin;
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);
    removeAllFingers();
    setUpGame();
  }

  public void setUpGame() {
    gameStarted = true;
    i = 1;
    aiWon = 0;
    playerWon = 0;
  }

  public boolean isGameStarted() {
    if (gameStarted == true) {
      return true;
    } else {
      return false;
    }
  }

  public void play() {
    if (isGameStarted()) {
      startRound();
      askUserInput();

      Jarvis jarvis = Player.createAi(difficulty);
      jarvis.runStrategy(calculateAverage(i), i, checkMostPlayedFingers());

      result(jarvis.getFingers(), jarvis.getSum());
      gameEnd();
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void startRound() {
    MessageCli.START_ROUND.printMessage(Integer.toString(i));
  }

  public void askUserInput() {
    do {
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    } while (!isInputValid());

    MessageCli.PRINT_INFO_HAND.printMessage(player, fingers, sum);
    playerFingerList.add(Integer.parseInt(fingers));
    i++;
  }

  public boolean isInputValid() {

    String[] inputString = input.split("\\s+"); // split by whitespace

    if (inputString.length == 2) {
      fingers = inputString[0];
      sum = inputString[1];
      if (Utils.isInteger(fingers) && Utils.isInteger(sum)) {
        int fingersInt = Integer.parseInt(fingers);
        int sumInt = Integer.parseInt(sum);
        if (fingersInt >= 1 && fingersInt <= 5) {
          if (sumInt >= 1 && sumInt <= 10) {
            return true;
          } else {
            MessageCli.INVALID_INPUT.printMessage();
            return false;
          }
        } else {
          MessageCli.INVALID_INPUT.printMessage();
          return false;
        }
      } else {
        MessageCli.INVALID_INPUT.printMessage();
        return false;
      }
    } else {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
  }

  public int calculateAverage(int i) {
    double sum = 0;
    double average = 0;
    int size = playerFingerList.size();

    for (int j = 0; j < size - 1; j++) {
      sum += playerFingerList.get(j);
    }
    if (i > 1) {
      average = sum / (size - 1);
    }
    int averageInt = (int) Math.round(average);
    return averageInt;
  }

  public void removeAllFingers() {
    playerFingerList.clear();
  }

  public int checkMostPlayedFingers() {
    int count = 0;
    int mostPlayedFingers = 0;
    int max = 0;
    int maxIndex = 0;
    ArrayList<Integer> countPlayedFingersList = new ArrayList<Integer>();

    if (i > 1) {
      for (int j = 0; j < playerFingerList.size() - 1; j++) {
        mostPlayedFingers = playerFingerList.get(j);
        for (int k = 0; k < playerFingerList.size() - 1; k++) {
          if (k != j && playerFingerList.get(k) == mostPlayedFingers) {
            count++;
          }
        }
        countPlayedFingersList.add(count);
        count = 0;
      }

      for (int j = 0; j < countPlayedFingersList.size() - 1; j++) {
        if (countPlayedFingersList.get(j) > max) {
          max = countPlayedFingersList.get(j);
          maxIndex = j;
        }
      }
    }
    return playerFingerList.get(maxIndex);
  }

  public void result(int aiFingers, int aiSum) {
    int fingersInt = Integer.parseInt(fingers);
    int sumInt = Integer.parseInt(sum);

    if ((fingersInt + aiFingers) == aiSum) {
      if ((fingersInt + aiFingers) == sumInt) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
        aiWon++;
      }
    } else {
      if ((fingersInt + aiFingers) == sumInt) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
        playerWon++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      }
    }
  }

  public void showStats() {
    if (isGameStarted()) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          player, Integer.toString(playerWon), Integer.toString(pointsToWin - playerWon));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(aiWon), Integer.toString(pointsToWin - aiWon));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void gameEnd() {
    if (playerWon == pointsToWin) {
      MessageCli.END_GAME.printMessage(player, Integer.toString(i - 1));
      gameStarted = false;
    } else if (aiWon == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(i - 1));
      gameStarted = false;
    }
  }
}
