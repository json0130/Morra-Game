package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String input;
  private String fingers;
  private String sum;
  private String player;
  private int i = 1;
  private Difficulty difficulty;
  Player Jarvis = new Player();

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    this.difficulty = difficulty;
    player = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(player);
    
  }

  public void play() {
      i = 1;
      startRound();
      askUserInput();

      Jarvis.getStrategy(difficulty);
      Jarvis.runStrategy();

      result();
  }

  public void startRound(){
      MessageCli.START_ROUND.printMessage(Integer.toString(i)); 
  }

  public void askUserInput() {
    do{
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
    }while(!isInputValid());

    MessageCli.PRINT_INFO_HAND.printMessage(player, fingers, sum);
    i++;
  }    

  public boolean isInputValid() {

    String[] inputString = input.split("\\s+"); // split by whitespace

    if (inputString.length == 2)
    {
      fingers = inputString[0];
      sum = inputString[1];
      if (Utils.isInteger(fingers) && Utils.isInteger(sum)) 
      {
        int fingersInt = Integer.parseInt(fingers);
        int sumInt = Integer.parseInt(sum);
        if (fingersInt >= 1 && fingersInt <= 5) {
            if (sumInt >= 1 && sumInt <= 10) {
              return true;
            }
            else {
              MessageCli.INVALID_INPUT.printMessage();
              return false;
            }
          }
          else {
            MessageCli.INVALID_INPUT.printMessage();
            return false;
          }
        }
        else {
          MessageCli.INVALID_INPUT.printMessage();
          return false;
        }
      }
    else {
      MessageCli.INVALID_INPUT.printMessage();
      return false;
    }
  }

  public void result() {
    int fingersInt = Integer.parseInt(fingers);
    int sumInt = Integer.parseInt(sum);
    // int aiFingers = Integer.parseInt(Jarvis.getStrategy(difficulty).getFingers());
    // int aiSum = Integer.parseInt(Jarvis.getStrategy(difficulty).getSum());

    if ((fingersInt + aiFingers) == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    }
    else if ((fingersInt + aiFingers) == sumInt) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    }
    else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  } 
  
  public void showStats() {
  }
}
