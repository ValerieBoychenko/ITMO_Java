package commands;

import base_class.MusicBand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
/**
 * Команда для сохранения данных о музыкальных группах в файл в формате JSON.
 */
public class Save extends Command {
    /**
     * Метод для сохранения данных о музыкальных группах в файл в формате JSON.
     * Запрашивает у пользователя имя файла, в который будут сохранены данные.
     * Преобразует объекты музыкальных групп в JSON-объекты и записывает их в массив JSON.
     * Затем записывает массив JSON в указанный файл.
     * В случае ошибки при записи в файл выводит сообщение об ошибке.
     */
    public void save(String fileName){
        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"))) {
            writer.write(parsingData().toJSONString());
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {

            System.err.println("Ошибка при записи данных в файл");
        }
    }
    public JSONArray parsingData(){
        JSONArray jsonArray = new JSONArray();
        for (MusicBand band : musicBands.getMusicBands().values()) {
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
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: Save - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: Save" + " - / " + new Date().toString() + " /";
    }

}
