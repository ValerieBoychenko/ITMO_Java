package commands;

import base_class.MusicBand;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Команда для замены значения музыкальной группы по ключу, если новое значение больше старого.
 */
public class ReplaceIfGreater extends Command {
    /**
     * Метод для замены значения музыкальной группы по указанному ключу, если новое значение больше старого.
     * Если введенный ключ некорректен, метод перехватывает InputMismatchException и выводит сообщение об ошибке.
     * Если новое значение музыкальной группы не инициализировано, метод генерирует NullPointerException.
     * Если старое значение музыкальной группы по указанному ключу не существует, метод генерирует NullPointerException.
     *
     * @throws NullPointerException если новое значение музыкальной группы не инициализировано
     *                              или если старое значение музыкальной группы по указанному ключу не существует
     */
    public void replaceIfGreater() {
        try {
            System.out.println("Enter key: ");
            Scanner in = new Scanner(System.in);
            Integer key = in.nextInt();
            var musicBand = new MusicBand().createNewMusicBand();
            if (musicBand == null) {
                throw new NullPointerException("musicBand is not initialized.\n" + this.toString());
            }
            MusicBand oldValue = musicBands.getMusicBands().get(key);

            if (oldValue != null && musicBand.compareTo(oldValue) > 0) {
                musicBands.put(key, musicBand);
            }else {
                throw new NullPointerException("oldValue is not initialized.\n" + this.toString());
            }
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: ReplaceIfGreater - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: ReplaceIfGreater"  + " - / " + new Date().toString() + " /";
    }

}
