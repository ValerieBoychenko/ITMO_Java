package commands;

import base_class.MusicBand;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import workingWithFile.FileWriter;

import java.io.*;
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
        try {
            new FileWriter().writing(fileName);
        } catch (Exception e) {
            System.err.println("Ошибка при записи данных в файл");
        }
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
