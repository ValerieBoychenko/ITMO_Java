package commands;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Команда для удаления музыкальных групп с ключами, меньшими указанного значения.
 */
public class RemoveLowerKey extends Command {
    /**
     * Метод для удаления музыкальных групп с ключами, меньшими указанного значения.
     * Если введенный ключ некорректен, метод перехватывает InputMismatchException и выводит сообщение об ошибке.
     * Если ключ в TreeMap равен null, метод генерирует NullPointerException.
     *
     * @throws NullPointerException если ключ в TreeMap равен null
     */
    public void removeLowerKey() {
        try {
            var newMusicBands = musicBands.getMusicBands();
            System.out.println("Enter key: ");
            Scanner in = new Scanner(System.in);
            Integer key = in.nextInt();
            newMusicBands.keySet().removeIf(k -> {
                if (k == null) {
                    throw new NullPointerException("Key in the map cannot be null");
                }
                return k < key;
            });
            musicBands.updateCollection(newMusicBands);
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: RemoveLowerKey - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: RemoveLowerKey" + " - / " + new Date().toString() + " /";
    }

}
