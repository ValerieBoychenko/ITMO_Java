package workingWithFile;

import base_class.MusicBand;
import commands.Command;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Date;
/**
 * Команда для записи данных о музыкальных группах в файл в формате JSON.
 */
public class Writer{
    /**
     * Метод для записи данных о музыкальных группах в файл в формате JSON.
     * Создает JSON-массив и заполняет его JSON-объектами, представляющими музыкальные группы.
     * Каждый JSON-объект содержит информацию об одной музыкальной группе.
     * Затем записывает JSON-массив в указанный файл.
     * В случае ошибки при записи в файл выводит сообщение об ошибке.
     *
     * @param fileName имя файла, в который будут записаны данные
     */
    public void writing( String fileName){
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
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса и текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: Writer - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: Writer" + " - / " + new Date().toString() + " /";
    }

}
