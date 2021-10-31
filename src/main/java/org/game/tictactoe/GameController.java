package org.game.tictactoe;

import org.game.tictactoe.dto.Move;
import org.game.tictactoe.service.TicTacToeGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
	
	@Autowired
	TicTacToeGameService ticTacToeGameService;
	
	@PostMapping("/move")
	String makeMove(@RequestBody Move move) {
		System.out.println(move);
		return ticTacToeGameService.makeMove(move);
	}
	
	@GetMapping("/reset")
	boolean resetGame() {
		ticTacToeGameService.resetGame();
		return true;
	}
}
