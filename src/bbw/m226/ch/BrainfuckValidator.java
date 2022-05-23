package bbw.m226.ch;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BrainfuckValidator {

    public String getOptimizedBrainfuck(String brainfuckExp) {
        StringBuilder optimizedBrainfuck = new StringBuilder();
        int deletedChars = 0;
        for (int charAt = 0; charAt < brainfuckExp.length(); charAt++) {
            switch (brainfuckExp.charAt(charAt)) {
                case '+', '-', '<', '>', '[', ']', '.', ',' -> optimizedBrainfuck.append(brainfuckExp.charAt(charAt));
                default -> deletedChars++;
            }
        }
        System.out.println("Number of sorted out chars: " + deletedChars);
        return optimizedBrainfuck.toString();

    }

    public boolean isBrainfuckValid(String optimizedBrainfuck) {
        int countForBrachet = 0;

        if (optimizedBrainfuck.contains("[") || optimizedBrainfuck.contains("]")) {
            for (int charAt = 0; charAt < optimizedBrainfuck.length(); charAt++) {
                if (optimizedBrainfuck.charAt(charAt) == '[') {
                    countForBrachet++;
                } else if (optimizedBrainfuck.charAt(charAt) == ']') {
                    countForBrachet--;
                }
            }
        }
        return countForBrachet == 0;
    }

    public String getBrainfuckOutput(String brainfuckExp) {
        String output = "";
        ArrayList<Integer> storage = new ArrayList();
        storage.add(0);

        int storagePointer = 0;
        int currentValue;
        Stack<Integer> jumpBackIndexes = new Stack<>();

        for (int charAt = 0; charAt < brainfuckExp.length(); charAt++) {
            switch (brainfuckExp.charAt(charAt)) {
                case '+' -> {
                    currentValue = storage.get(storagePointer);
                    if(currentValue < 255){
                        currentValue++;
                    }else{
                        currentValue = 0;
                    }
                    storage.set(storagePointer, currentValue);
                }
                case '-' -> {
                    currentValue = storage.get(storagePointer);
                    if(currentValue > 0){
                        currentValue--;
                    }else{
                        currentValue = 255;
                    }
                    storage.add(storagePointer, currentValue);
                }
                case '.' -> {
                    currentValue = storage.get(storagePointer);
                    System.out.println((char) currentValue);
                }
                case ',' -> {
                    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Give me your Input for comma at index: " + storagePointer);
                    String stdIn = myObj.nextLine();
                    for (int indexAt = 0; indexAt < stdIn.length(); indexAt++) {
                        storage.add((storagePointer + indexAt), (int) stdIn.charAt(indexAt));
                    }
                }
                case '>' -> {
                    try {
                        storage.get(storagePointer + 1);
                        storagePointer++;
                    } catch (IndexOutOfBoundsException e) {
                        storage.add(storagePointer + 1, 0);
                        storagePointer++;
                    }
                }
                case '<' -> {
                    if (storagePointer == 0) {
                        storage.add(0);
                    } else {
                        storagePointer--;
                    }
                }
                case '[' -> {
                    jumpBackIndexes.push(charAt);
                }
                case ']' -> {
                    if (storage.get(storagePointer) != 0) {
                        charAt = jumpBackIndexes.get(0);
                    } else {
                        jumpBackIndexes.pop();
                    }
                }
                default -> {
                    System.err.println("Error while interpreting the following character {" + storage.get(storagePointer) + "} Please try again..");
                }
            }
        }

        return output;
    }
}
