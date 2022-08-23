package ru.gb.task4;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * 01.04.2022 22:50
 *
 * @author PetSoft
 */
public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';
    private static final int SIZE = 5;
    private static final int WIN_SEQUENCE = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAI;
    private static int scoreHuman;
    private static int scoreAI;
    private static int roundCounter;

    public static void main(String[] args) {
        startNewGame();
    }

    private static void aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (isCellValid(y, x));

        field[y][x] = dotAI;
    }

    private static void humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Please enter coordinates x & y >>>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isCellValid(y, x));

        field[y][x] = dotHuman;
    }

    private static void startNewGame() {
        while (true) {
            chooseDot();
            playRound();

            System.out.printf("""
                    SCORE:   HUMAN   AI
                    %d     %d
                    """, scoreHuman, scoreAI);
            System.out.print("Want to play again? (Y or N) >>> ");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) {
                System.out.println("BYE");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("Round %d start\n", ++roundCounter);
        initField();
        printField();
        if (dotHuman == DOT_X) {
            humanFirst();
        } else {
            aiFirst();
        }
    }

    private static void humanFirst() {
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            printField();
            if (gameCheck(dotAI)) {
                break;
            }
        }
    }


    private static void aiFirst() {
        while (true) {
            aiTurn();
            printField();
            if (gameCheck(dotAI)) {
                break;
            }
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private static boolean gameCheck(char dot) {
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("Human win!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAI) {
            System.out.println("AI win!");
            scoreAI++;
            return true;
        }
        return checkDraw();
    }

    private static void chooseDot() {
        System.out.print("Type 'X' to play with X and for 0 type anything >>> ");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
            dotHuman = DOT_X;
            dotAI = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAI = DOT_X;
        }
    }

    private static boolean checkDraw() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        System.out.println("Draw!");
        return true;
    }

    private static boolean checkWin(char dot) {
        int hor = 0;
        int ver = 0;
        int diag;

        //horizontal and vertical sequence
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (field[i][j] == dot) {
                    hor++;
                } else if (field[i][j] != dot) {
                    hor = 0;
                }

                if (field[j][i] == dot) {
                    ver++;
                } else if (field[j][i] != dot) {
                    ver = 0;
                }

                if (hor == WIN_SEQUENCE || ver == WIN_SEQUENCE) {
                    return true;
                }
            }
        }

        //forward diagonal sequence
        for (int i = 0; i < SIZE; i++) {
            diag = 0;
            for (int j = 0; j < SIZE; j++) {
                int y = i + j;
                if (y < SIZE) {
                    if (field[j][y] == dot) {
                        diag++;
                    } else if (field[j][y] != dot && diag < WIN_SEQUENCE) {
                        diag = 0;
                    }
                }
                if (diag == WIN_SEQUENCE) {
                    return true;
                }
            }
        }

        for (int j = 1; j < SIZE; j++) {
            diag = 0;
            for (int i = 0; i < SIZE; i++) {
                int x = j + i;
                if (x < SIZE) {
                    if (field[x][i] == dot) {
                        diag++;
                    } else if (field[x][i] != dot) {
                        diag = 0;
                    }
                }
                if (diag == WIN_SEQUENCE) {
                    return true;
                }
            }
        }

        //backward diagonal sequence
        for (int j = 0; j < SIZE; j++) {
            diag = 0;
            for (int i = 0; i < SIZE; i++) {
                int y = (SIZE - 1) - i;
                int x = j + i;
                if (x < SIZE) {
                    if (field[x][y] == dot) {
                        diag++;
                    } else if (field[x][y] != dot) {
                        diag = 0;
                    }
                }
                if (diag == WIN_SEQUENCE) {
                    return true;
                }
            }
        }

        for (int j = 1; j < SIZE; j++) {
            diag = 0;
            for (int i = 0; i < SIZE; i++) {
                int y = (SIZE - 1) - j - i;
                if (y >= 0) {
                    if (field[i][y] == dot) {
                        diag++;
                    } else if (field[i][y] != dot) {
                        diag = 0;
                    }
                }
                if (diag == WIN_SEQUENCE) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCellValid(int y, int x) {
        return x < 0 || y < 0 || x >= SIZE || y >= SIZE || field[y][x] != DOT_EMPTY;
    }

    private static void initField() {
        field = new char[SIZE][SIZE];
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");

        for (int i = 0; i < SIZE * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.print("-");
        }
    }
}
