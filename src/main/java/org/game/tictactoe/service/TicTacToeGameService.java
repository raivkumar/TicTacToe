package org.game.tictactoe.service;

import org.game.tictactoe.dto.Move;

public interface TicTacToeGameService {

	/**
	 * Make the move in game as per the give input
	 * @param move Object containing move details
	 * @return result of the move
	 */
	String makeMove(Move move);
	
	/**
	 * Reset the game so that it can be played afresh
	 */
	void resetGame();
}
