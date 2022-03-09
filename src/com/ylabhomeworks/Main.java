package com.ylabhomeworks;

import java.util.Random;
import java.util.Scanner;

public class Main {

    final char Cross = 'X';
    final char Zero = '0';
    final char EmptyToe = '*';
    char [][] table;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new Main().game();
    }

    Main(){
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
    }

    void game() {
        initTable();
        while (true) {
            turnHooman1();
            if (checkWin(Cross)){
                System.out.println("Player 1 WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Round draw!");
                break;
            }
            turnHooman2();
            printTable();
            if (checkWin(Zero)){
                System.out.println("Player 2 WON!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Round draw!");
                break;
            }
        }
        System.out.println("GAME OVER M8 GOT REKT");
        printTable();
    }

    void initTable() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                table[row][col] = EmptyToe;
    }

    void printTable() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++)
                System.out.print(table[row][col] + " ");
            System.out.println();
        }
    }

    void turnHooman1() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = Cross;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3|| y >= 3) {
            System.out.println("Wrong coordinates!");
            return false;}
        return table[y][x] == EmptyToe;
    }

    void turnHooman2() {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3):");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = Zero;
    }
    boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == dot && table[i][1] == dot && table[i][2] == dot) || (table[0][i] == dot && table[1][i] == dot && table[2][i] == dot))
                return true;
        if ((table[0][0] == dot && table[1][1] == dot && table[2][2] == dot) || (table[2][0] == dot && table[1][1] == dot && table[0][2] == dot))
            return true;
        return false;
    }
    boolean isTableFull() {
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                if (table[row][col] == EmptyToe)
                    return false;
        return true;
    }
}
