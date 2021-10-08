/**
 * Main Class - the runner class of the "Zork" game.
 *
 * Author:  Gevin Kood
 * Version: 1
 * Date:    October 2019
 * 
 *  To play this game, the main method creates an instance 
 *  of the Game class and calls the "play" method.
 */

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
    boolean willMoment = game.play();
    String end = (willMoment) ? "Yay! You won!" : "Thank you for playing. Goodbye.";
    System.out.println(end);
  }
}

