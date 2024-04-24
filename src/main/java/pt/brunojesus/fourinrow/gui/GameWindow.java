package pt.brunojesus.fourinrow.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7253238536622895506L;
	private static final int ROWS = 6;
    private static final int COLS = 7;
    private JButton[][] boardButtons;
    private IForInRow board;

    public GameWindow(IForInRow board) {
    	this.board = board;
        setTitle("Four in a Row");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS + 1, COLS));

        boardButtons = new JButton[ROWS][COLS];

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boardButtons[row][col] = new JButton();
                boardButtons[row][col].setBackground(Color.WHITE);
                boardButtons[row][col].setOpaque(true);
                final int finalRow = row;
                final int finalCol = col;
                boardButtons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	board.play(finalCol);
                    	update(finalCol);
                        // Handle button click
//                        JOptionPane.showMessageDialog(null, "Button clicked: Row " + (finalRow + 1) + ", Column " + (finalCol + 1));
                    }
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
    
    public void update(int col) {
    	for (int row = 0; row < ROWS; row++) {
    		boardButtons[row][col].setBackground(board.getItemInPosition(row, col));
    	}
    }

    private void resetBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                boardButtons[row][col].setBackground(Color.WHITE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow(new Board());
            }
        });
    }
}
