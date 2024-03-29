package commands;

import base_class.MusicBand;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * Команда для удаления музыкальных групп с ключами, большими указанного значения.
 */
public class RemoveGreater extends Command {
    /**
     * Метод для удаления музыкальных групп с ключами, большими указанного значения.
     * Если введенный ключ некорректен, метод перехватывает InputMismatchException и выводит сообщение об ошибке.
     * Если ключ в TreeMap равен null, метод генерирует NullPointerException.
     *
     * @throws NullPointerException если ключ в TreeMap равен null
     */
    public void removeGreater() throws NullPointerException {
        try {
            for (Integer key : musicBands.getMusicBands().keySet()){
                System.out.println("Name: " + musicBands.getMusicBands().get(key).getName() + " -> "  + key);
            }
            TreeMap<Integer, MusicBand> newMusicBands = musicBands.getMusicBands();
            int key = CheckCorrectKey.checking();
            newMusicBands.keySet().removeIf(k -> {
                if (k == null) {
                    throw new NullPointerException("Key in the map cannot be null");
                }
                return k > key;
            });
            musicBands.updateCollection(newMusicBands);
            System.out.println("Collection after deleting items: ");
            for (Integer newKey : musicBands.getMusicBands().keySet()){
                System.out.println("Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> "  + newKey);
            }
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: RemoveGreater - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: RemoveGreater" + " - / " + new Date().toString() + " /";
    }

}
