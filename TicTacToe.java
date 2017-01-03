import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple TicTacToe game to introduce JFrame.
 *
 * Created by dlu on 12/2/2016.
 */
public class TicTacToe {
    static String xMarker = "X";
    static String oMarker = "O";
    static String blankMarker = " ";
    static JButton spaces[];

    public static void main(String[] args) {
        String title = "Simple Tic Tac Toe";
        int width = 3;
        int height = 3;

        JFrame jf = new JFrame(title);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(width, height));
        spaces = new JButton[height * width];
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new TTTButton();
            jp.add(spaces[i]);                  // Add button to panel.
        }
        jf.add(jp);                             // Add panel to frame.

        jf.pack();
        jf.setVisible(true);
    }

    private static class TTTButton extends JButton implements ActionListener {

        private static int turn = 0;

        public TTTButton() {
            super();
            setPreferredSize(new Dimension(200, 200));
            setOpaque(true);
            setFont(new Font("Helvetica", Font.PLAIN, 100));
            setText(" ");
            addActionListener(this);
        }

        // Notice button clicks to record moves.
        public void actionPerformed(ActionEvent e) {
            if (turn % 2 == 0 && getText().equals(" ")) {
                setForeground(Color.BLACK);
                setText(xMarker);
            } else if (turn % 2 == 1 && getText().equals(" ")) {
                setForeground(Color.RED);
                setText(oMarker);
            }
           // else if (getText("Y")){
             //Working with newGame
          //  }
            if (isThereAWinner()) {
                shallWePlayAgain();

            } else if (noPlaceLeftToPlay()) {
                shallWePlayAgain();
            }
            else {
                turn++;
            }
        }

        // Check if someone has won the game.
        private boolean isThereAWinner() {
            if (spaces[0].getText() == spaces[1].getText() && spaces[1].getText() == spaces[2].getText() && spaces[0].getText() != blankMarker) { //side to side
                System.out.println("you win.");
                showWin(0, 1, 2);
                return true;
            }
            else if (spaces[3].getText() == spaces[4].getText() && spaces[4].getText() == spaces[5].getText() && spaces[3].getText() != blankMarker) { //side to side
                System.out.println("you win.");
                showWin(3, 4, 5);
                return true;
            }
            else if (spaces[6].getText() == spaces[7].getText() && spaces[7].getText() == spaces[8].getText() && spaces[6].getText() != blankMarker) { //side to side
                System.out.println("you win.");
                showWin(6, 7, 8);
                return true;
            }
            else if (spaces[0].getText() == spaces[3].getText() && spaces[3].getText() == spaces[6].getText() && spaces[0].getText() != blankMarker){ //up and down
                System.out.println("you win.");
                showWin(0, 3, 6);
                return true;
            }
            else if (spaces[1].getText() == spaces[4].getText() && spaces[4].getText() == spaces[7].getText() && spaces[1].getText() != blankMarker) { //up and down
                System.out.println("you win.");
                showWin(1, 4, 7);
                return true;
            }
            else if (spaces[2].getText() == spaces[5].getText() && spaces[5].getText() == spaces[8].getText() && spaces[2].getText() != blankMarker) { //up and down
                System.out.println("you win.");
                showWin(5, 8, 2);
                return true;
            }
            else if (spaces[0].getText() == spaces[4].getText() && spaces[4].getText() == spaces[8].getText() && spaces[0].getText() != blankMarker) { //diagonal down right
                System.out.println("you win.");
                showWin(0, 4, 8);
                return true;
            }
            else if (spaces[2].getText() == spaces[4].getText() && spaces[4].getText() == spaces[6].getText() && spaces[2].getText() != blankMarker) { //diagonal down left
                System.out.println("you win.");
                showWin(6, 4, 2);
                return true;
            }
            else return false;
        }


        // Check if there is still space to play.
        private boolean noPlaceLeftToPlay() {
            if (spaces[0].getText() != blankMarker && spaces[1].getText() != blankMarker && spaces[2].getText() != blankMarker && spaces[3].getText() != blankMarker
                    && spaces[4].getText() != blankMarker && spaces[5].getText() != blankMarker && spaces[6].getText() != blankMarker && spaces[7].getText() != blankMarker &&
                    spaces[8].getText() != blankMarker) {
                System.out.println("Cat game");
                return true;
            }
            else return false;
        }

        // Prompt user for a new game. Else exit.
        private void shallWePlayAgain() {
            spaces[0].setText(" ");
            spaces[1].setText(" ");
            spaces[2].setText(" ");
            spaces[3].setText("Y");
            spaces[4].setText(" ");
            spaces[5].setText("N");
            spaces[6].setText(" ");
            spaces[7].setText(" ");
            spaces[8].setText(" ");
            //need to make it understand that once you press those buttons, create a new board and new game
        }

        // Mark the winning moves.
        private void showWin(int s0, int s1, int s2) {
            spaces[s0].setForeground(Color.BLUE);
            spaces[s1].setForeground(Color.BLUE);
            spaces[s2].setForeground(Color.BLUE);
           // JPanel.sleep(50);  //need to make a pause after a win. Need to change color to blue.
        }

        // Reset the game so that it can be played again.
        private void newGame() {
       /*     if (turn = spaces[3].getText()){
                return;
            }
            else if (turn = spaces[5].getText()){
                return;
            }
            else {
            } */ //this last part does not work yet. Revisions needed
        }
        }
        }
    }

}
