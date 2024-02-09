import java.util.Scanner;
public class Main {
    public static void welcomeMessage () {
        System.out.println("Hello and welcome to Viktors Sudoku");
        System.out.println("Guess the missing number");
    }
    public static void main(String[] args) {
        Scanner userInput=new Scanner(System.in);

        int[][] sudokuNumbersarray = {{1,2,3},{1,2,3},{1,2,3}};
        welcomeMessage();
        System.out.println("_____________");
        for (int i=0; i<sudokuNumbersarray.length;i++) {
            System.out.print("| ");
            for (int j = 0; j < sudokuNumbersarray[0].length; j++) {
                System.out.print(sudokuNumbersarray[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("_____________");
      int[] sudokuInputarray = {1};
      sudokuInputarray[0] = userInput.nextInt();

    }
}
//todo add randomizer, hide number, add calculation logic