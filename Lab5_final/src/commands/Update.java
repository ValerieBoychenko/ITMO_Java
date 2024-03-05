package commands;

import base_class.MusicBand;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Команда для обновления элемента в коллекции музыкальных групп.
 */
public class Update extends Command {
    /**
     * Метод для обновления элемента в коллекции музыкальных групп.
     * Запрашивает у пользователя ключ элемента для обновления.
     * Создает новый объект MusicBand с помощью метода createNewMusicBand().
     * Если новый объект не инициализирован, метод генерирует NullPointerException.
     * Если элемент с указанным ключом существует в коллекции, обновляет его новым объектом.
     * Если элемент с указанным ключом не найден, выводит сообщение о том, что элемент не найден в коллекции.
     * В случае ошибки при вводе ключа, метод перехватывает InputMismatchException и выводит сообщение об ошибке.
     *
     * @throws NullPointerException если новый объект MusicBand не инициализирован
     */
    public void update() {
        try {
            System.out.println("Enter key: ");
            Scanner in = new Scanner(System.in);
            Integer key = in.nextInt();
            var newMusicBand = new MusicBand().createNewMusicBand();
            if (newMusicBand == null) {
                throw new NullPointerException("newMusicBand is not initialized.\n" + this.toString());
            }
            if (musicBands.getMusicBands().containsKey(key)) {
                musicBands.put(key, newMusicBand);
                System.out.println("An element with a key " + key + " successfully updated.");
            } else {
                System.out.println("An element with a key " + key + " not found in the collection.");
            }
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: Update - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: Update" + " - / " + new Date().toString() + " /";
    }

}
