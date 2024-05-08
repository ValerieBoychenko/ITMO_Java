package collectionHandler;

import models.MusicBand;

import java.util.Date;
import java.util.TreeMap;

/**
 * Класс, представляющий коллекцию музыкальных групп и управляющий ею.
 */
public class MusicBandCollection {
    private TreeMap<Integer, MusicBand> musicBands;
    private final Date initializationDate;

    /**
     * Конструктор по умолчанию, инициализирующий пустую коллекцию музыкальных групп.
     */
    public MusicBandCollection(){
        this.musicBands = new TreeMap<>();
        this.initializationDate = new Date();
    }

    /**
     * Возвращает дату инициализации коллекции.
     * @return дата инициализации
     */
    public Date getInitializationDate() {
        return initializationDate;
    }

    /**
     * Обновляет коллекцию музыкальных групп новыми данными.
     * @param newMusicBands новая коллекция музыкальных групп
     */
    public void updateCollection(TreeMap<Integer, MusicBand> newMusicBands){
        this.musicBands = newMusicBands;
    }

    /**
     * Возвращает коллекцию музыкальных групп.
     * @return коллекция музыкальных групп
     */
    public TreeMap<Integer, MusicBand> getMusicBands() {
        return musicBands;
    }

    /**
     * Добавляет новую музыкальную группу в коллекцию.
     * @param key ключ для связывания с музыкальной группой
     * @param musicBand музыкальная группа для добавления
     */
    public void put(Integer key, MusicBand musicBand){
        musicBands.put(key, musicBand);
    }

    /**
     * Удаляет музыкальную группу из коллекции по указанному ключу.
     * @param key ключ музыкальной группы для удаления
     */
    public void remove(Integer key){
        musicBands.remove(key);
    }
}