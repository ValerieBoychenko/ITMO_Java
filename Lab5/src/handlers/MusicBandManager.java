package handlers;

import base_class.Coordinates;
import base_class.Label;
import base_class.MusicBand;
import base_class.MusicGenre;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.*;

/**
 * Класс, управляющий коллекцией музыкальных групп и их сохранением в файле JSON.
 */
public class MusicBandManager {
    private TreeMap<Integer, MusicBand> musicBands;// Коллекция музыкальных групп
    private final Date initializationDate; // Дана создания класса

    /**
     * Конструктор по умолчанию, инициализирующий пустую коллекцию музыкальных групп.
     */
    public MusicBandManager(){
        this.musicBands = new TreeMap<>();
        this.initializationDate = new Date();
    }

    /**
     * Загружает данные о музыкальных группах из файла JSON.
     * @param fileName имя файла для загрузки данных
     */

    public void loadDataFromFile(String fileName) {
        JSONParser parser = new JSONParser();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            Object obj = parser.parse(reader);

            JSONArray jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                Integer key = new Random().nextInt();
                JSONObject bandObj = (JSONObject) o;
                String name = (String) bandObj.get("name");
                JSONObject coordinatesObj = (JSONObject) bandObj.get("coordinates");
                Float x = ((Number) coordinatesObj.get("x")).floatValue();
                Integer y = ((Number) coordinatesObj.get("y")).intValue();
                String creationDateString = (String) bandObj.get("creationDate");
                int numberOfParticipants = ((Number) bandObj.get("numberOfParticipants")).intValue();
                long albumsCount = ((Number) bandObj.get("albumsCount")).longValue();
                String establishmentDateString = (String) bandObj.get("establishmentDate");
                String genreString = (String) bandObj.get("genre");
                JSONObject labelObj = (JSONObject) bandObj.get("label");
                long labelBands = ((Number) labelObj.get("bands")).longValue();

                Coordinates coordinates = new Coordinates(x, y);
                java.time.ZonedDateTime creationDate = java.time.ZonedDateTime.parse(creationDateString);
                java.util.Date establishmentDate = java.util.Date.from(java.time.ZonedDateTime.parse(establishmentDateString).toInstant());
                MusicGenre genre = MusicGenre.valueOf(genreString.toUpperCase());
                Label label = new Label(labelBands);

                MusicBand musicBand = new MusicBand(name, coordinates, numberOfParticipants, albumsCount, establishmentDate, genre, label);

                this.musicBands.put(key, musicBand);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Записывает данные о музыкальных группах в файл JSON.
     * @param fileName имя файла для записи данных
     */

    public void writingToFile(String fileName){
        JSONArray jsonArray = new JSONArray();
        for (MusicBand band : musicBands.values()) {
            // Создаем JSONObject для каждой группы
            JSONObject bandObj = new JSONObject();
            bandObj.put("id", band.getId());
            bandObj.put("name", band.getName());
            bandObj.put("coordinates", band.getCoordinates().toJson());
            bandObj.put("creationDate", band.getCreationDate().toString());
            bandObj.put("numberOfParticipants", band.getNumberOfParticipants());
            bandObj.put("albumsCount", band.getAlbumsCount());
            bandObj.put("establishmentDate", band.getEstablishmentDate().toString());
            bandObj.put("genre", band.getGenre().toString());
            bandObj.put("label", band.getLabel().toJson());

            // Добавляем JSONObject в массив jsonArray
            jsonArray.add(bandObj);
        }

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write(jsonArray.toJSONString());
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при записи данных в файл");
        }
    }

    /**
     * Возвращает дату инициализации коллекции.
     * @return дата инициализации
     */
    public Date getInitializationDate() {
        return initializationDate;
    }
    /**
     * Возвращает коллекцию музыкальных групп.
     * @return коллекция музыкальных групп
     */
    public TreeMap<Integer, MusicBand> getMusicBands(){
        return musicBands;
    }

    /**
     * Вставляет новую музыкальную группу в коллекцию с указанным ключом.
     * @param key ключ для связывания с музыкальной группой
     * @param musicBand музыкальная группа для вставки
     */
    public void insertNewElement(Integer key, MusicBand musicBand){
        musicBands.put(key, musicBand);
    }

    /**
     * Обновляет музыкальную группу в коллекции с указанным ключом.
     * @param key ключ музыкальной группы для обновления
     * @param newMusicBand новая музыкальная группа для замены существующей
     */
    public void updateElement(Integer key, MusicBand newMusicBand){
        if (musicBands.containsKey(key)) {
            musicBands.put(key, newMusicBand);
            System.out.println("An element with a key " + key + " successfully updated.");
        } else {
            System.out.println("An element with a key " + key + " not found in the collection.");
        }
    }

    /**
     * Удаляет музыкальную группу из коллекции с указанным ключом.
     * @param key ключ музыкальной группы для удаления
     */
    public void removeElement(Integer key){
        musicBands.remove(key);
    }

    /**
     * Удаляет все музыкальные группы из коллекции.
     */
    public void clearAllElement(){
        musicBands.clear();
    }

    /**
     * Удаляет все музыкальные группы с ключами больше указанного ключа.
     * @param key ключ для сравнения
     */
    public void removeGreaterElement(Integer key){
        musicBands.keySet().removeIf(k -> k > key);
    }

    /**
     * Заменяет музыкальную группу в коллекции с указанным ключом на новую музыкальную группу, если новая музыкальная группа больше существующей.
     * @param key ключ музыкальной группы для замены
     * @param newMusicBand новая музыкальная группа
     */
    public void replaceIfGreaterElement(Integer key, MusicBand newMusicBand) {
        MusicBand oldValue = musicBands.get(key);
        if (oldValue != null && newMusicBand.compareTo(oldValue) > 0) {
            musicBands.put(key, newMusicBand);
        }
    }

    /**
     * Удаляет все музыкальные группы с ключами меньше указанного ключа.
     * @param key ключ для сравнения
     */
    public void removeLowerKeyElement(Integer key){
        musicBands.keySet().removeIf(k -> k < key);
    }

    /**
     * Подсчитывает количество музыкальных групп с жанрами меньше указанного жанра.
     * @param genre жанр для сравнения
     * @return количество музыкальных групп с жанрами меньше указанного жанра
     */
    public Integer countLessThanGenreElement(MusicGenre genre){
        int count = 0;
        for (MusicBand band : musicBands.values()) {
            if (band.getGenre().compareTo(genre) < 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Фильтрует и возвращает список музыкальных групп, имена которых начинаются с указанной строки.
     * @param name префикс имен музыкальных групп для фильтрации
     * @return список музыкальных групп, имена которых начинаются с указанной строки
     */
    public List<MusicBand> filterStartsWithName(String name){
        List<MusicBand> filteredBands = new ArrayList<>();
        for (MusicBand band : musicBands.values()) {
            if (band.getName().startsWith(name)) {
                filteredBands.add(band);
            }
        }
        return filteredBands;
    }

    /**
     * Печатает жанры музыкальных групп в порядке убывания.
     */
    public void printFieldDescendingGenre() {
        musicBands.descendingMap().forEach((key, value) -> System.out.println(value.getGenre()));
    }
}
