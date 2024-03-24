package commands;

import java.util.InputMismatchException;
import java.util.Scanner;

import static commands.Command.musicBands;

public class CheckCorrectKey {
     static public Integer checking(){
        System.out.println("Enter key: ");
        Scanner in = new Scanner(System.in);
        int key;
        while (true){
            try {
                key = in.nextInt();
                if (musicBands.getMusicBands().get(key) != null){
                    break;
                } else {
                    System.out.println("Key does not exist.");
                }
            } catch (InputMismatchException e) {
                System.out.println("The input error must be of type Integer (< 2147483647).");
                in.nextLine();
            }
        }
        return key;
    }
}
