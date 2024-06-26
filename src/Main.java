import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void welcomeMessage() {
        System.out.println("Hello and welcome to Viktors 3x3 Sudoku");
    }

    public static void guessNumber() {
        System.out.println("What number do you think should replace the question mark?");
    }

    public static void printArray(String[][] sudokuNumbersarray) {
        System.out.println("_____________");
        for (int i = 0; i < sudokuNumbersarray.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < sudokuNumbersarray[0].length; j++) {
                System.out.print(sudokuNumbersarray[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("_____________");
    }

    public static void solution(String[][] sudokuNumbersarray) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream(new File("sudukosolution.txt"));
        fileStream.println("_____________");
        for (int i = 0; i < sudokuNumbersarray.length; i++) {
            String s = "";
            s = s + "| ";
            for (int j = 0; j < sudokuNumbersarray[0].length; j++) {
                s = s + sudokuNumbersarray[i][j] + " | ";
            }
            fileStream.println(s);
        }
        fileStream.println("_____________");
    }

    public static void shuffleRowonearray(String[][] sudokuArray) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));
        Collections.shuffle(numbers);
        for (int i = 0; i < sudokuArray.length; i++) {
            sudokuArray[0][i] = Integer.toString(numbers.get(i));
        }
    }

    public static void shuffleRowtwoarray(String[][] sudokuArray) {
        if (sudokuArray[0][0].equals("1")) {
            sudokuArray[1][0] = "2";
        } else if (sudokuArray[0][0].equals("2")) {
            sudokuArray[1][0] = "3";
        } else {
            sudokuArray[1][0] = "1";
        }
        if (sudokuArray[0][1].equals("1")) {
            sudokuArray[1][1] = "2";
        } else if (sudokuArray[0][1].equals("2")) {
            sudokuArray[1][1] = "3";
        } else {
            sudokuArray[1][1] = "1";
        }
        if (Integer.parseInt(sudokuArray[1][0]) + Integer.parseInt(sudokuArray[1][1]) == 3) {
            sudokuArray[1][2] = "3";
        } else if (Integer.parseInt(sudokuArray[1][0]) + Integer.parseInt(sudokuArray[1][1]) == 4) {
            sudokuArray[1][2] = "2";
        } else {
            sudokuArray[1][2] = "1";
        }

    }

    public static void shuffleRowthreearray(String[][] sudokuArray) {
        if (Integer.parseInt(sudokuArray[0][0]) + Integer.parseInt(sudokuArray[1][0]) == 3) {
            sudokuArray[2][0] = "3";
        } else if (Integer.parseInt(sudokuArray[0][0]) + Integer.parseInt(sudokuArray[1][0]) == 4) {
            sudokuArray[2][0] = "2";
        } else {
            sudokuArray[2][0] = "1";
        }
        if (Integer.parseInt(sudokuArray[0][1]) + Integer.parseInt(sudokuArray[1][1]) == 3) {
            sudokuArray[2][1] = "3";
        } else if (Integer.parseInt(sudokuArray[0][1]) + Integer.parseInt(sudokuArray[1][1]) == 4) {
            sudokuArray[2][1] = "2";
        } else {
            sudokuArray[2][1] = "1";
        }
        if (Integer.parseInt(sudokuArray[0][2]) + Integer.parseInt(sudokuArray[1][2]) == 3) {
            sudokuArray[2][2] = "?";
        } else if (Integer.parseInt(sudokuArray[0][2]) + Integer.parseInt(sudokuArray[1][2]) == 4) {
            sudokuArray[2][2] = "?";
        } else {
            sudokuArray[2][2] = "?";
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        String[][] sudokuNumbersarray = new String[3][3];
        welcomeMessage();
        shuffleRowonearray(sudokuNumbersarray);
        shuffleRowtwoarray(sudokuNumbersarray);
        shuffleRowthreearray(sudokuNumbersarray);
        printArray(sudokuNumbersarray);
        guessNumber();
        int[] sudokuInputarray = {1};

        sudokuInputarray[0] = userInput.nextInt();

        boolean foundNumber = false;
        File sudukolog = new File("sudukolog.txt");
        sudukolog.createNewFile();
        FileWriter fw = new FileWriter(sudukolog);
        while (!foundNumber) {
            fw.write((Integer.toString(sudokuInputarray[0])));
            if (Integer.parseInt(sudokuNumbersarray[2][0]) + Integer.parseInt(sudokuNumbersarray[2][1]) + sudokuInputarray[0] == 6) {
                sudokuNumbersarray[2][2] = Integer.toString(sudokuInputarray[0]);
                System.out.println("Awesome, you were correct and win the glorious competition.");
                printArray(sudokuNumbersarray);
                foundNumber = true;
            } else {
                System.out.println("Wrong answer, try again");
                sudokuInputarray[0] = userInput.nextInt();
            }
        }
        solution(sudokuNumbersarray);
        fw.close();
    }
}