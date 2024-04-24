package pt.brunojesus.fourinrow.gui;

import java.awt.Color;

public class Board implements IForInRow {
	
	private static final int ROWS = 6;
    private static final int COLS = 7;
	Color[][] board;
	Color lastPlayed = Color.YELLOW;
	
	public Board() {
		this.board = new Color[ROWS][COLS];
	}

	@Override
	public Color getItemInPosition(int row, int col) {
		return this.board[row][col];
	}

	@Override
	public Color getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void play(int col, Color color) {
		for (int row = ROWS - 1; row >= 0; row--) {
			if (board[row][col] == null) {
				board[row][col] = color;
				lastPlayed = color;
				break;
			}
		}	
	}

	@Override
	public void play(int x) {
		Color color = lastPlayed == Color.YELLOW ? Color.RED : Color.YELLOW;
		play(x, color);
	}

}
