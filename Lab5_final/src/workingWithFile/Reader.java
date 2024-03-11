package workingWithFile;

import base_class.Coordinates;
import base_class.Label;
import base_class.MusicBand;
import base_class.MusicGenre;
import commands.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Random;
/**
 * Команда для чтения данных о музыкальных группах из файла JSON и добавления их в коллекцию.
 */
public class Reader {
    /**
     * Метод для чтения данных о музыкальных группах из файла JSON и добавления их в коллекцию.
     *
     * @param fileName имя файла, из которого будут считываться данные
     */
    public void read(String fileName) {
        var newMusicBands = Command.musicBands.getMusicBands();
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

                newMusicBands.put(key, musicBand);
                Command.musicBands.updateCollection(newMusicBands);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println(this.toString());
        }
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: Reader - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: Reader" + " - / " + new Date().toString() + " /";
    }
}
