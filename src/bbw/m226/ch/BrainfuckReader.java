package bbw.m226.ch;

import java.util.Scanner;

public class BrainfuckReader {

    public static void main(String[] args) {
        //Print a welcome message
        StartTextHelper startTextHelper = new StartTextHelper();
        startTextHelper.getStartText();

        BrainfuckValidator brainfuckValidator = new BrainfuckValidator();

        //Reading user input
        String brainfuckExp = "";

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Brainfuck expression: ");
        brainfuckExp = myObj.nextLine();  // Read user input

        brainfuckExp = brainfuckValidator.getOptimizedBrainfuck(brainfuckExp);
        if (brainfuckValidator.isBrainfuckValid(brainfuckExp)) {
            brainfuckValidator.getBrainfuckOutput(brainfuckExp);
        }
    }
}
