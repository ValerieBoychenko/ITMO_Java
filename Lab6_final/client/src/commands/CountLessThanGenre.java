package commands;


import parser.ManualInput;

import java.io.Serial;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CountLessThanGenre extends Command implements Serializable {

    private String genre;
    @Serial
    private static final long serialVersionUID = 3L;

    public void executeReadParameters(){
        try {
            String[] genres = {"POP", "BLUES", "ROCK", "POST_ROCK", "BRIT_POP"};
            System.out.println("Choose a genre: " + "\n" +
                    "-- ROCK" + "\n" +
                    "-- BLUES" + "\n" +
                    "-- POP" + "\n" +
                    "-- POST_ROCK" + "\n" +
                    "-- BRIT_POP");
            int flag = 0;
            while (true) {
                System.out.println("Enter genre: ");
                String currentGenre = new ManualInput().nextLine();
                try {
                    for (String a : genres) {
                        if (a.equals(currentGenre)) {
                            this.genre = currentGenre;
                            flag = 1;
                            break;
                        }
                    }
                    System.out.println("Genre does not exist.");
                } catch (InputMismatchException e) {
                    System.out.println("The input error must be of type String.");
                }
                if (flag == 1){
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("The genre was entered incorrectly!");
        }
    }
}

