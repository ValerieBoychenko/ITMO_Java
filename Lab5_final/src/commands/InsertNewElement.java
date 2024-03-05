package commands;

import base_class.MusicBand;
import exception.CommandException;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

/**
 * Класс InsertNewElement предоставляет функционал для добавления нового элемента в коллекцию.
 */
public class InsertNewElement extends Command {

    /**
     * Добавляет новый элемент в коллекцию с заданным ключом.
     * @throws NullPointerException если коллекция не была инициализирована или произошла ошибка при вводе ключа.
     */
    public void insertNewElement() throws NullPointerException {
        try {
            // Запрос ввода нового ключа
            System.out.println("Введите новый ключ:");
            Scanner in = new Scanner(System.in);
            Integer key = in.nextInt();
            // Проверка на инициализацию коллекции
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            // Создание новой музыкальной группы и добавление в коллекцию
            var musicBand = new MusicBand().createNewMusicBand();
            musicBands.put(key, musicBand);
        } catch (InputMismatchException e) {
            // В случае ошибки ввода ключа, выводим сообщение об ошибке
            System.out.println("Ключ введен неверно!" + "\n" + new InsertNewElement().toString());
        }
    }

    @Override
    public String toString(){
        // Возвращаем строковое представление класса с указанием времени
        return "Имя класса: InsertNewElement" + " - / " + new Date().toString() + " /";
    }
}

