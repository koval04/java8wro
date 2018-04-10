package com.github.xenteros.game2048.model;

/**
 * Klasa przechowująca planszę, czyli obecny stan gry. Nie powinna zarządzać samą rozgrywką, a udostępniać metody
 * pozwalające na wykonanie poszczególnych ruchów.
 */
public class Board {
    private int rotateNumber;
    private int moveNumber;

    public int getRotateNumber() {
        return rotateNumber;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setRotateNumber(int rotateNumber) {
        this.rotateNumber = rotateNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }


    public static void main(String[] args) {

        int gameBoard[][] = new int[][]{
                new int[]{2, 2, 2, 2},
                new int[]{2, 2, 4, 8},
                new int[]{16, 16, 0, 0},
                new int[]{2, 0, 4, 2}};
        displayGameBoard(gameBoard);
        System.out.println("----------");
//        displayGameBoard(move(gameBoard));
        System.out.println("----------");
    }

    public static void displayGameBoard(int gameBoard[][]) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++)
                System.out.print(gameBoard[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] move(int[][] array, int moveNumber) {

        for (int k = 0; k < array.length; k++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if (array[i][j] == 0)
                        if (array[i][j] < array[i][j + 1])
                            swap(i, j, array);
                    if (array[i][j] != 0 || moveNumber > 1) merge(array);
                    moveNumber--;
                }
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[][] array) {
        int temp = array[i][j];
        array[i][j] = array[i][j + 1];
        array[i][j + 1] = temp;
    }

    public static void merge(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    int temp = array[i][j];
                    array[i][j] = temp + array[i][j + 1];
                    array[i][j + 1] = 0;
                }
            }

        }

    }

    public static int[][] rotate(int[][] array, int rotateNumber) {
        final int M = array.length;
        final int N = array[0].length;
        int[][] ret = new int[N][M];
        Board board = new Board();
        int n = 1;
        board.rotateNumber = n;
        for (int j = 0; j <rotateNumber; j++) {
            for (int i = 0; i < n; i++) {
                for (int r = 0; r < M; r++) {
                    for (int c = 0; c < N; c++) {
                        ret[c][M - 1 - r] = array[r][c];
                    }
                }
            }
        }
        return ret;
    }

    public static void rotateAndMarge(int array[][]) {


    }
}
