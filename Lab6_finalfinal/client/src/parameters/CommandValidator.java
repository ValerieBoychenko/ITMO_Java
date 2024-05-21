package parameters;

import models.MusicBand;
import parser.ManualInput;

import java.util.InputMismatchException;

public class CommandValidator {
    public static Parameters Validation(TypeParameter typeParameter){
        if (typeParameter == TypeParameter.KEY){
            return inputKey();
        }
        if (typeParameter == TypeParameter.GENRE){
            return inputGenre();
        }
        if (typeParameter == TypeParameter.NONE){
            return null;
        }
        if (typeParameter == TypeParameter.NAME){
            return inputName();
        }
        if (typeParameter == TypeParameter.KEY_AND_MUSIC_BAND){
            return inputMusicBand();
        }
        return null;
    }


    private static Parameters inputKey(){
        String key = null;
        int flag = 0;
        while (flag == 0) {
            System.out.println("Enter key: ");
            String currentKey = new ManualInput().nextLine();
            try {
                Integer.parseInt(currentKey);
                key = currentKey;
                flag = 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid key. Please enter a valid integer key.");
                flag = 0;
            }

        }
        return new Parameters(key);
    }

    private static Parameters inputGenre() {
        try {
            String genre = null;
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
                            genre = currentGenre;
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Genre does not exist.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The input error must be of type String.");
                }
                if (flag == 1) {
                    break;
                }
            }
            return new Parameters(genre);
        } catch (InputMismatchException e) {
            System.out.println("The genre was entered incorrectly!");
        }
        return null;
    }

    private static Parameters inputName(){
        String name = null;
        System.out.println("Enter name: ");
        name = new ManualInput().nextLine();
        return new Parameters(name);
    }

    private static Parameters inputMusicBand(){
        MusicBand musicBand = null;
        String key = null;
        System.out.println("Enter key: ");
        String currentKey = new ManualInput().nextLine();
        try {
            Integer.parseInt(currentKey);
            key = currentKey;
        } catch (NumberFormatException e) {
            System.out.println("Invalid key. Please enter a valid integer key.");
            inputMusicBand();
        }
        musicBand = new MusicBand().createNewMusicBand();
        return new Parameters(key, musicBand);
    }
}
