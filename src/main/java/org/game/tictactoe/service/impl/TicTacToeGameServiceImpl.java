package org.game.tictactoe.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.game.tictactoe.GameConstants;
import org.game.tictactoe.dto.GameDTO;
import org.game.tictactoe.dto.Move;
import org.game.tictactoe.dto.Player;
import org.game.tictactoe.service.TicTacToeGameService;
import org.springframework.stereotype.Service;

@Service
public class TicTacToeGameServiceImpl implements TicTacToeGameService {

	private final GameDTO game = new GameDTO();
	private int moveCount = 0;
	private Player lastMoveBy = null;

	Predicate<String> ALL_X = x -> "XXX".equals(x);
	Predicate<String> ALL_O = y -> "OOO".equals(y);

	@Override
	public String makeMove(Move move) {
		if (move.getPlayer().equals(lastMoveBy)) {
			throw new IllegalArgumentException(GameConstants.CONSECUTIVE_MOVE_BY_SAME_PLAYER);
		}
		int index = (move.getRow() - 1) * GameConstants.MAX_COLUMNS + (move.getColumn() - 1);
		if (game.isMoveAt(index)) {
			throw new IllegalArgumentException(GameConstants.SLOT_ALREADY_OCCUPIED);
		}
		lastMoveBy = move.getPlayer();
		game.setMoveAt(move.getPlayer().name(), index);
		moveCount++;

		// A win is possible only after minimum 5 moves (3 for the winning player and 2
		// for the losing player)
		if (moveCount > 4) {
			return this.checkResult();
		}
		return null;
	}

	/**
	 * Check the result of game.
	 * 
	 * @return outcome of the game after each invocation.
	 */
	private String checkResult() {
		String[] moves = game.getMoves();
		List<String> winningsCombos = new ArrayList();
		winningsCombos.add(moves[0] + moves[1] + moves[2]); // row 1
		winningsCombos.add(moves[3] + moves[4] + moves[5]); // row 2
		winningsCombos.add(moves[6] + moves[6] + moves[8]); // row 3
		winningsCombos.add(moves[0] + moves[3] + moves[6]); // column 1
		winningsCombos.add(moves[1] + moves[4] + moves[7]); // column 2
		winningsCombos.add(moves[2] + moves[5] + moves[8]); // column 3
		winningsCombos.add(moves[0] + moves[4] + moves[8]); // diagonal 1
		winningsCombos.add(moves[2] + moves[4] + moves[6]); // diagonal 2

		if (winningsCombos.stream().anyMatch(ALL_X)) {
			this.resetGame();
			return "Player X Won";
		} else if (winningsCombos.stream().anyMatch(ALL_O)) {
			this.resetGame();
			return "Player O Won";
		} else if (moveCount == 9) {
			this.resetGame();
			return "It's a Draw. No one wins";
		}
		return null;
	}

	@Override
	public void resetGame() {
		this.moveCount = 0;
		this.lastMoveBy = null;
		game.reset();
	}
}
