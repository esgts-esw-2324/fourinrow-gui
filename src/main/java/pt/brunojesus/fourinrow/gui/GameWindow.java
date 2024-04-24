package pt.brunojesus.fourinrow.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The GameWindow representing a Four in a Row game.
 * Requires a graphical display
 */
public class GameWindow extends JFrame {
	private static final long serialVersionUID = 7253238536622895506L;
	private static final int ROWS = 6;
    private static final int COLS = 7;
    private JButton[][] boardButtons;
    private IBoard board;

    /**
     * The GameWindow constructor
     *
     * @param board The board logic implementation
     */
    public GameWindow(IBoard board) {
    	this.board = board;
        init();
    }

    private void init() {
        setTitle("Four in a Row");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS + 1, COLS));

        boardButtons = new JButton[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boardButtons[row][col] = new JButton();
                boardButtons[row][col].setBackground(Color.WHITE);
                boardButtons[row][col].setOpaque(true);
                final int finalCol = col;
                boardButtons[row][col].addActionListener(e -> {
                    board.play(finalCol);
                    update(finalCol);
                });
                add(boardButtons[row][col]);
            }
        }

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle reset button click
                resetBoard();
            }
        });
        add(resetButton);

        pack();
        setVisible(true);
    }
    
    private void update(int col) {
    	for (int row = 0; row < ROWS; row++) {
            Color color = board.getItemInPosition(row, col);
            color = color == null ? Color.WHITE : color;
    		boardButtons[row][col].setBackground(color);
    	}
    }

    private void resetBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boardButtons[row][col].setBackground(Color.WHITE);
            }
        }
    }
}
