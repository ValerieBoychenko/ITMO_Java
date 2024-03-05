package commands;

import handlers.MusicBandCollection;

/**
 * Базовый класс для представления команды.
 * Содержит статическое поле для доступа к коллекции музыкальных групп.
 */
public class Command {

    /**
     * Статическое поле, представляющее коллекцию музыкальных групп.
     */
    static public MusicBandCollection musicBands;

    /**
     * Статический блок инициализации, создающий новый экземпляр коллекции музыкальных групп.
     * Обрабатывает возможные исключения при инициализации.
     */
    static {
        try {
            musicBands = new MusicBandCollection();
        } catch (NullPointerException e) {
            System.err.println("Collection initialization error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Collection initialization error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

