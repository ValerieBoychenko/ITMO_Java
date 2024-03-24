package commands;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Команда для удаления музыкальной группы по ключу.
 */
public class RemoveKey extends Command {
    /**
     * Метод для удаления музыкальной группы по указанному ключу.
     * Если введенный ключ некорректен, метод перехватывает InputMismatchException и выводит сообщение об ошибке.
     * Если указанный ключ не существует в коллекции, метод выводит сообщение о том, что ключ не существует.
     *
     * @throws ClassCastException если происходит попытка приведения типов
     */
    public void remove() {
        System.out.println("Keys: ");
        try {
            for (Integer key : musicBands.getMusicBands().keySet()){
                System.out.println("Name: " + musicBands.getMusicBands().get(key).getName() + " -> "  + key);
            }
            int key = CheckCorrectKey.checking();
            musicBands.remove(key);
            for (Integer newKey : musicBands.getMusicBands().keySet()){
                System.out.println("Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> "  + newKey);
            }
        } catch (ClassCastException e) {
            System.out.println("Key not exist");
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }

    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: RemoveKey - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: RemoveKey" + " - / " + new Date().toString() + " /";
    }
}
