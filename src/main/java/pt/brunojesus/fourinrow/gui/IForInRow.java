package pt.brunojesus.fourinrow.gui;

import java.awt.Color;

public interface IForInRow {
	Color getItemInPosition(int x, int y);
	Color getWinner();
	void play(int x, Color color);
	void play(int x);
}
