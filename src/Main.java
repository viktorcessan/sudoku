import java.util.Scanner;
public class Main {
    public static void welcomeMessage () {
        System.out.println("Hello and welcome to Viktors Sudoku");
        System.out.println("Guess the missing number, what should replace the question mark?");
    }
    public static void guessNumber(){
        System.out.println("What number do you think it is?");
    }
    public static void printArray(String[][]sudokuNumbersarray){
        System.out.println("_____________");
        for (int i=0; i<sudokuNumbersarray.length;i++) {
            System.out.print("| ");
            for (int j = 0; j < sudokuNumbersarray[0].length; j++) {
                System.out.print(sudokuNumbersarray[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("_____________");
    }
    public static void main(String[] args) {
        Scanner userInput=new Scanner(System.in);

        String[][] sudokuNumbersarray = {{"1","2","3"},{"2","3","1"},{"3","1","?"}};
        welcomeMessage();
        printArray(sudokuNumbersarray);
      int[] sudokuInputarray = {1};
      sudokuInputarray[0] = userInput.nextInt();
      guessNumber();
      if (Integer.parseInt(sudokuNumbersarray[2][0])+Integer.parseInt(sudokuNumbersarray[2][1])+sudokuInputarray[0]==6){
          sudokuNumbersarray[2][2]=Integer.toString(sudokuInputarray[0]);
          System.out.println("Awesome, you were correct and win the glorious competition.");
          printArray(sudokuNumbersarray);
          }
      else {System.out.println("Wrong answer");
      }
    }
}
//todo add randomizer,