package commands;


import workingWithFile.FileWriter;

import java.util.Date;
import java.util.Map;


public class Save {

    public void execute(){
        try {
            Map<String, String> env = System.getenv();
            new FileWriter().writing(env.get("FILE_PATH"));
        } catch (Exception e) {
            System.err.println("Ошибка при записи данных в файл");
        }
    }

    @Override
    public String toString(){
        return "Class name: Save" + " - / " + new Date().toString() + " /";
    }

}
