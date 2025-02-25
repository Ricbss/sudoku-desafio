import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGUI {
    private static final int SIZE = 9;
    private static int[][] board = {
            {0, 4, 9, 5, 8, 6, 2, 3, 1},
            {1, 3, 5, 4, 7, 2, 8, 9, 6},
            {2, 6, 8, 9, 1, 3, 7, 4, 5},
            {5, 1, 3, 7, 6, 4, 9, 8, 2},
            {8, 9, 7, 1, 2, 5, 3, 6, 4},
            {6, 4, 2, 3, 9, 8, 1, 5, 7},
            {7, 5, 4, 2, 3, 9, 6, 1, 8},
            {9, 8, 1, 6, 4, 7, 5, 2, 3},
            {3, 2, 6, 8, 5, 1, 4, 7, 9}
    };

    private static JTextField[][] cells = new JTextField[SIZE][SIZE];

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sudoku Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new JTextField(board[i][j] == 0 ? "" : String.valueOf(board[i][j]));
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                frame.add(cells[i][j]);
            }
        }

        JButton validateButton = new JButton("Validate");
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSolved()) {
                    JOptionPane.showMessageDialog(frame, "Parabéns! Você completou o Sudoku!");
                } else {
                    JOptionPane.showMessageDialog(frame, "O jogo ainda não está correto.");
                }
            }
        });

        frame.add(validateButton);
        frame.setVisible(true);
    }

    private static boolean isSolved() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
}
