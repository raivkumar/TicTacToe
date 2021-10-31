package org.game.tictactoe.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.game.tictactoe.GameConstants;
import org.game.tictactoe.dto.Move;
import org.game.tictactoe.dto.Player;
import org.game.tictactoe.service.impl.TicTacToeGameServiceImpl;
import org.junit.Test;

public class TicTacToeGameServiceTest {

	private final TicTacToeGameService ticTacToeGameService = new TicTacToeGameServiceImpl();
	
	@Test
	public void test_consecutive_move_by_same_player_is_rejected() {
		Move move = new Move();
		move.setPlayer(Player.X);
		move.setColumn(1);
		move.setRow(1);
		
		ticTacToeGameService.makeMove(move);
		
		Exception ex = assertThrows(IllegalArgumentException.class, ()-> ticTacToeGameService.makeMove(move));
		assertEquals(GameConstants.CONSECUTIVE_MOVE_BY_SAME_PLAYER, ex.getMessage());
	}

	@Test
	public void test_move_to_an_occupied_position_is_rejected() {
		Move move = new Move();
		move.setPlayer(Player.X);
		move.setColumn(1);
		move.setRow(1);
		
		ticTacToeGameService.makeMove(move);
		move.setPlayer(Player.O);
		
		Exception ex = assertThrows(IllegalArgumentException.class, ()-> ticTacToeGameService.makeMove(move));
		assertEquals(GameConstants.SLOT_ALREADY_OCCUPIED, ex.getMessage());
	}
}
