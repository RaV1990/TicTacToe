package tictactoepackage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TicTacToe gra = new TicTacToe();
        gra.playAMatch();

/*
        JFrame frame = new WindowForGame();
        frame.setContentPane(new WindowForGame().panelMain);
        frame.setContentPane(new WindowForGame().button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
*/
    }
}
