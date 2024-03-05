package commands;


import java.util.Date;
import java.util.TreeMap;

/**
 * Класс, представляющий команду для очистки коллекции.
 * Наследуется от абстрактного класса Command.
 */
public class Clear extends Command {

    /**
     * Очищает коллекцию музыкальных групп.
     * @throws NullPointerException если коллекция музыкальных групп не инициализирована
     */
    public void clear() throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
        }
        musicBands.updateCollection(new TreeMap<>());
    }

    /**
     * Возвращает строковое представление объекта.
     * @return строка, содержащая название класса и текущую дату и время
     */
    @Override
    public String toString(){
        return "Class name: Clear" + " - / " + new Date().toString() + " /";
    }

}
