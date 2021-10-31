REST API for 2 player TicTacToe game.
=====================================

There are 2 APIs:
1. POST server-base-url/move
-----------------------------

To make a move for the player X or O, at the given position.
Position can be specified in row ( 1 to 3), and column (1 to 3)


data 
{
    
    "player" : "X" or "O",

    "row" : row index (numeric 1 to 3),

    "column" : column index (numeric 1 to 3)
}


2.  GET server-base-url/reset
-----------------------------
Reset the game so it can be played again. 
This API does not need to be called explicitly after a game is finished.

