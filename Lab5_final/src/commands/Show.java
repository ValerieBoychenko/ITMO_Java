package commands;

import base_class.MusicBand;

import java.util.Date;
/**
 * Команда для отображения информации о музыкальных группах.
 */
public class Show extends Command {
    /**
     * Метод для отображения информации о музыкальных группах.
     * Получает коллекцию музыкальных групп из MusicBands.
     * Если коллекция не инициализирована, метод генерирует NullPointerException.
     * Выводит информацию о каждой музыкальной группе в консоль.
     * Если ключ в коллекции равен null, метод генерирует NullPointerException.
     */
    public void show() {
        var bands = musicBands.getMusicBands();
        if (bands == null) {
            throw new NullPointerException("Bands is not initialized.\n" + this.toString());
        }
        for (Integer key : bands.keySet()) {
            if (key == null){
                throw new NullPointerException("Key is null.\n" + this.toString());
            }
            MusicBand band = musicBands.getMusicBands().get(key);
            System.out.println(band.toString());
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: Show - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: Show" + " - / " + new Date().toString() + " /";
    }

}
