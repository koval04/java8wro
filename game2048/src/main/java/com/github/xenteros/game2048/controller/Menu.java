package com.github.xenteros.game2048.controller;

import com.github.xenteros.game2048.controller.*;
import com.github.xenteros.game2048.model.Board;

import java.util.Scanner;

import static com.github.xenteros.game2048.model.Board.displayGameBoard;
import static com.github.xenteros.game2048.model.Board.move;
import static com.github.xenteros.game2048.model.Board.rotate;

/**
 * Ta klasa to tylko propozycja, jak sensownie rodzielić kod na więcej klas.
 * Ta klasa może odpowiadać za pobieranie decyzji
 * użytkownika. W ten sposób oddzielimy pobieranie danych od użytkownika od przetwarzania tych danych. Dzięki temu,
 * w przyszłości będziemy mogli podmienić tę klasę na klasę, która losuje ruch, albo wykonuje najlepszy ruch,
 * według naszego algorytmu.
 */
class Menu {

    public static void main(String[] args) {

        int gameBoard[][] = new int[][]{new int[]{2, 2, 2, 2},
                new int[]{2, 2, 4, 8},
                new int[]{16, 16, 0, 0},
                new int[]{2, 0, 4, 2}};


        String menu;
        final String exit = "5";
        Scanner scanner = new Scanner(System.in);
        System.out.println("W) Ruch w góre \nS) Ruch w dol \nD) Ruch w prawo\nA) Ruch w lewo \n5) wyjscie \nN) Wyswietl tablice ");
        System.out.println("Wybierz");

        Board board = new Board();
        int moveNumber = board.getMoveNumber();
        int rotateNumber = board.getRotateNumber();
        do {
            menu = scanner.nextLine();
            switch (menu) {
                case "N":
                    displayGameBoard(gameBoard);
                    break;
                case "A":
                    moveNumber++;
                    rotateNumber =0;
                    break;
                case "W":
                    moveNumber++;
                    rotateNumber =1;
                    break;
                case "D":
                    moveNumber++;
                    rotateNumber =2;
                    break;
                case "S":
                    moveNumber++;
                    rotateNumber =3;
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Brak takiej opcji");
            }
        } while (menu != "5");
        System.out.println("Nara");
    }
}