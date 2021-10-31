package org.game.tictactoe.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Move {
	@NonNull
	Player player;
	
	@Min(value = 1, message = "Minimum ROW can be 1")
	@Max(value = 3, message = "Maximum ROW can be 3")
	int row;

	@Min(value = 1, message = "Minimum COLUMN can be 1")
	@Max(value = 3, message = "Maximum COLUMN can be 3")
	int column;
}
