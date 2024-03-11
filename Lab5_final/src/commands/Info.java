package commands;

import java.util.Date;


/**
 * Класс Info предоставляет функционал для вывода информации о коллекции музыкальных групп.
 */
public class Info extends Command {

    /**
     * Выводит информацию о коллекции музыкальных групп в стандартный поток вывода.
     * @throws NullPointerException если коллекция не была инициализирована.
     */
    public void info() throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("musicBands is not initialized.\n" + this.toString());
        }
        System.out.println("Информация о коллекции музыкальных групп:");
        System.out.println("Тип коллекции: TreeMap<String, base_class.MusicBand>");
        System.out.println("Дата инициализации: " + musicBands.getInitializationDate());
        System.out.println("Количество элементов: " + musicBands.getMusicBands().size());
    }

    @Override
    public String toString(){
        return "Имя класса: Info" + " - / " + new Date().toString() + " /";
    }

}

