package pt.brunojesus.fourinrow.gui;

import java.awt.Color;

/**
 * IBoard interface
 * <p>
 * Defines the required interface in order to interact with the {@link GameWindow}
 *
 * @author Bruno Jesus
 * @since 1.0
 */
public interface IBoard {

    /**
     * Gets the item on the desired position
     *
     * @param col the Column to access (0 based)
     * @param row the Row to access (0 based)
     * @return the player color, <b>null</b> if position is empty
     */
    Color getItemInPosition(int col, int row);

    /**
     * Gets the winner
     *
     * @return the color of the winner, <b>null</b> if none
     */
    Color getWinner();

    /**
     * Plays in the desired column
     *
     * @param col   the Column to play into
     * @param color the player's color to play
     */
    void play(int col, Color color);

    /**
     * Plays in the desired column.
     * The {@link Color} is determined automatically
     *
     * @param col the Column to play into
     */
    void play(int col);
}
