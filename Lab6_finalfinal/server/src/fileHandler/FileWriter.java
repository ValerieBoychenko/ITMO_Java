package fileHandler;

import models.MusicBand;
import commands.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;

public class FileWriter {

    public void writing(String fileName){
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write(parsingData().toJSONString());
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {

            System.err.println("Ошибка при записи данных в файл");
        }
    }
    public JSONArray parsingData(){
        JSONArray jsonArray = new JSONArray();
        for (MusicBand band : Command.musicBands.getMusicBands().values()) {
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
            jsonArray.add(bandObj);
        }
        return jsonArray;
    }

    @Override
    public String toString(){
        return "Class name: Writer" + " - / " + new Date().toString() + " /";
    }

}
