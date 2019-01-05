package tictactoepackage;

import java.util.Scanner;

public class TicTacToe {

    private final char [][] board;
    private int row, column;
    private boolean boardIsNotFull;
    private char winner;
    private char currentPlayer;
    private int [] score;
    private Scanner read = new Scanner(System.in);

    TicTacToe() {
        board = new char[3][3];
        winner = '-';
        currentPlayer = 'O';
        boardIsNotFull = false;
        score = new int [3];
        makePlainBoard();
        setScore(score);
    }

    private void setScore(int[] score) {
        this.score = score;
        score[0] = 0;
        score[1] = 0;
        score[2] = 0;
    }

    private void makePlainBoard() {
        for (row = 0; row < 3; row ++) {
            for (column = 0; column <3; column ++) {
                board[row][column] = '*';
            }
        }
    }

    private void drawBoard() {
        System.out.println("\nTIC-TAC-TOE GAME");
        for (row =0; row<3; row++)
        {
            System.out.println("-----------------");
            for (column =0; column<3; column++){
                System.out.print("| " + board[row][column] + " | ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
        System.out.println("");
    }

    private void checkHorizontalLines() { //poziom
        for (row = 0; row < 3; row ++) {
            if (board[row][0] == currentPlayer && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                winner = currentPlayer;
            }
        }
    }

    private void checkVerticalLines() { //pion
        for (column = 0; column < 3; column ++) {
            if (board[0][column] == currentPlayer && board[0][column] == board[1][column] && board[1][column] == board[2][column]) {
                winner = currentPlayer;
            }
        }
    }

    private void checkDiagonals() {
        if (board[0][0] == currentPlayer && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = currentPlayer;
        }
        if (board[2][0] == currentPlayer && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
            winner = currentPlayer;
        }
    }

    private boolean checkIsNotFull() {
        boardIsNotFull = false;
        if (winner == '-') {
            for (row = 0; row < 3; row++) {
                for (column = 0; column < 3; column ++) {
                    if (board[row][column] == '*')
                        boardIsNotFull = true;
                }
            }
        }
        return boardIsNotFull;
    }

    private void announceTheWinner() {
        if (winner == '-') {
            System.out.println("POJEDYNEK ZAKOŃCZONY REMISEM");
        }
        else
            System.out.println("Wygrywa gracz : " + currentPlayer + "\n GRATULACJE!");
    }

    private void checkForWinner() {
        checkHorizontalLines();
        checkVerticalLines();
        checkDiagonals();
        checkIsNotFull();
    }

    private void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }

    private void countToScore(char winner) {
        if (winner == 'O') {
            score[0]++;
        }
        if (winner == 'X') {
            score[1]++;
        }
    }

    private void makeAMove() {
        System.out.println("Ruch gracza " + currentPlayer);
        int fieldChoice = read.nextInt();
        switch (fieldChoice) {
            case 1: {
                if (board[0][0] == '*') {
                    board[0][0] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 2: {
                if (board[0][1] == '*') {
                    board[0][1] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 3: {
                if (board[0][2] == '*') {
                    board[0][2] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 4: {
                if (board[1][0] == '*') {
                    board[1][0] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 5: {
                if (board[1][1] == '*') {
                    board[1][1] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 6: {
                if (board[1][2] == '*') {
                    board[1][2] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 7: {
                if (board[2][0] == '*') {
                    board[2][0] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 8: {
                if (board[2][1] == '*') {
                    board[2][1] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            case 9: {
                if (board[2][2] == '*') {
                    board[2][2] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("Wybrane pole jest zajęte powtórz wybór");
                    makeAMove();
                    break;
                }
            }
            default: {
                System.out.println("NIEPOPRAWNY WYBÓR! WPROWADŹ NR POLA 1-9");
                makeAMove();
                break;
            }
        }
    }

    private void resetTheBoard() {
        winner = '-';
        makePlainBoard();
    }

    private void showScore(){
        System.out.println("WYNIK");
        System.out.println("O : " + score[0] + " X : " + score[1] + " REMIS : " + score[2] + "\n");
    }

    private void playASingleGame() {
        drawBoard();
        checkIsNotFull();
        while (winner == '-' && checkIsNotFull()) {
            showScore();
            makeAMove();
            checkForWinner();
            drawBoard();
            if (winner == '-') {
                changePlayer();
            }
        }
        countToScore(winner);
        announceTheWinner();
    }

    void playAMatch() {
        System.out.println("Ile rozgrywek chcesz przeprowadzić? " );
        int numberOfRounds = read.nextInt();
        for(int roundNumber = 1; roundNumber<=numberOfRounds; roundNumber++) {
            System.out.println("Runda " + roundNumber + " z " + numberOfRounds);
            playASingleGame();
            resetTheBoard();
            System.out.println(winner);
        }
        System.out.println("MECZ ZAKOŃCZONY!");
        System.out.println("Gracz O wygrał " + score[0] + " krotnie.");
        System.out.println("Gracz X wygrał " + score[1] + " krotnie.");
        System.out.println("Remis odnotowano "  + score[2] + " krotnie.");

    }
}