package commands;

import base_class.MusicBand;
import base_class.MusicGenre;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс, представляющий команду для подсчета количества музыкальных групп с жанром,
 * меньшим заданного.
 * Наследуется от базового класса Command.
 */
public class CountLessThanGenre extends Command {

    /**
     * Выполняет подсчет количества музыкальных групп с жанром, меньшим заданного.
     * @throws NullPointerException если возникает ошибка при выполнении команды
     */
    public void countLessThanGenre() throws NullPointerException {
        try {
            System.out.println("Choose a genre: " + "\n" +
                    "-- ROCK" + "\n" +
                    "-- BLUES" + "\n" +
                    "-- POP" + "\n" +
                    "-- POST_ROCK" + "\n" +
                    "-- BRIT_POP");
            System.out.println("Enter genre: ");
            Scanner in = new Scanner(System.in);
            String genre;
            while (true){
                try {
                    genre = in.nextLine();
                    if (MusicGenre.convert(genre) != null){
                        break;
                    } else {
                        System.out.println("Genre does not exist.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("The input error must be of type String.");
                    in.nextLine();
                }
            }
            int count = 0;
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            for (MusicBand band : musicBands.getMusicBands().values()) {
                if (band.getGenre().compareTo(Objects.requireNonNull(MusicGenre.convert(genre))) < 0) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (InputMismatchException e) {
            System.out.println("The genre was entered incorrectly!");
            countLessThanGenre();
        }
    }

    /**
     * Возвращает строковое представление объекта.
     * @return строка, содержащая название класса и текущую дату и время
     */
    @Override
    public String toString(){
        return "Class name: CountLessThanGenre" + " - / " + new Date().toString() + " /";
    }

}

