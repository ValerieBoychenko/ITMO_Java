package commands;


import exceptions.ConsoleOutputErrorException;
import parser.Parser;

import java.io.*;


public class ExecuteScript extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;
    private String fileName;
    public ExecuteScript(String fileName){
        this.fileName = fileName;
    }
    public void executeReadParameters(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String command;
            Parser parser= new Parser();
            while ((command = br.readLine()) != null) {
                parser.parsing(command);
            }
        } catch (IOException | ConsoleOutputErrorException | NullPointerException e) {
            e.getMessage();
        }
    }

    public String getFileName() {
        return fileName;
    }
}
