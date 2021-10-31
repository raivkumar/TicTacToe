package org.game.tictactoe.dto;

import org.game.tictactoe.GameConstants;

import lombok.Data;
import lombok.NonNull;

@Data
public class GameDTO {

	String[] moves = new String[GameConstants.MAX_ROWS * GameConstants.MAX_COLUMNS];

	public void setMoveAt(@NonNull String player, int index) {
		moves[index] = player;
	}

	public boolean isMoveAt(int index) {
		return moves[index] != null;
	}
	
	public void reset() {
		moves = new String[GameConstants.MAX_ROWS * GameConstants.MAX_COLUMNS];
	}
	
	
}
