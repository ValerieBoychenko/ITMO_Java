package fileHandler;

import models.Coordinates;
import models.Label;
import models.MusicBand;
import models.MusicGenre;
import commands.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class FileReader {
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
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                ZonedDateTime creationDate = ZonedDateTime.parse(creationDateString);
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(establishmentDateString, formatter);
                Date establishmentDate = Date.from(zonedDateTime.toInstant());
                MusicGenre genre = MusicGenre.valueOf(genreString.toUpperCase());
                Label label = new Label(labelBands);
                MusicBand musicBand = new MusicBand(name, coordinates, creationDate, numberOfParticipants, albumsCount, establishmentDate, genre, label);

                newMusicBands.put(key, musicBand);
                Command.musicBands.updateCollection(newMusicBands);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println(this.toString());
        }
    }

    @Override
    public String toString(){
        return "Class name: Reader" + " - / " + new Date().toString() + " /";
    }
}
