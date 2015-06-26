package ChessGame;

import java.awt.Color;

public class FourCases {
	private static Color turn = null;
	private static String[] players = {"playerW","playerB"};
	private static int[] scores = {0,0};

	/**
	 * Both players gain 1 point.
	 */
	public static void restart() {
		if (!initialized())
			return;
		scores[0]++;
		scores[1]++;
		turn = Color.WHITE;
	}

	public static void wins() {
		if (turn == Color.WHITE)
			scores[0]++;
		else
			scores[1]++;
		turn = Color.WHITE;
	}

	/**
	 * The opponent of the current player gets one point. 
	 * the game should then be reset.
	 */
	public static void forfeit() {
		if (initialized()){
		if (turn == Color.WHITE)
			scores[1]++;
		else
			scores[0]++;
		turn = Color.WHITE;}
		else return ;
	}

	/**
	 * When stalemate. Neither player gets any
	 * points.
	 */
	public static void draw() {
		turn = Color.WHITE;
	}

	/**
	 * Finds out which player's move is next.
	 * 
	 * @return current player's color
	 */
	public static Color getTurn() {
		return turn;
	}

	/**
	 * Gets the name of the current turn's player.
	 * 
	 * @return the name of the player who's turn it is
	 */
	public static String currentPlayer() {
		if (initialized()){
		if (turn == Color.WHITE)
			return players[0];
		else
			return players[1];}
		else return null;
	}

	/**
	 * Makes turn rotated.
	 */
	public static void nextTurn() {
		if (initialized()){
		if (turn == Color.WHITE)
			turn = Color.BLACK;
		else
			turn = Color.WHITE;}
		else return ;
		
		}
	
	
	/**
	 * assign the initial turn: white
	 */
	static void startGame() {
		if (!initialized())
			turn = Color.WHITE;
	}

	/**
	 * if a game has started or not.
	 * 
	 * @return true if initialized
	 */
	private static boolean initialized() {
		return (turn != null) ;
	}

	/**
	 * Gets a list of the players and scores and concatenates them together into
	 * a table for the user.
	 * 
	 * @return a string representation of the game scoreboard.
	 */
	public static String getScoreList() {
		if (initialized()){
		String result = "[Player] \t\t [Score]\n";
		for (int it = 0; it < 2; it++) {
			result += players[it] + " : " + scores[it] + "\n";
			}
			return result;
		}
		else return "Scores unavailable."; 

	}


}
