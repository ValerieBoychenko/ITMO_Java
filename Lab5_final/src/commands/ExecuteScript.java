package commands;

import exception.CommandException;
import exception.ConsoleOutputErrorException;
import handlers.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * Класс, представляющий команду для выполнения скрипта из файла.
 * Наследуется от базового класса Command.
 */
public class ExecuteScript extends Command {

    /**
     * Выполняет скрипт из файла, последовательно выполняя команды, содержащиеся в файле.
     */
    public void executeScript() {
        String fileName = "/Users/valeriabojcenko/IdeaProjects/Lab5_final/src/input_output_file/scripts.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String command;
            Parser  parser= new Parser(fileName);
            while ((command = br.readLine()) != null) {
                parser.parsing(command);
            }
        } catch (IOException | ConsoleOutputErrorException | NullPointerException e) {
            e.getMessage();
        }
    }

    /**
     * Возвращает строковое представление объекта.
     * @return строка, содержащая название класса и текущую дату и время
     */
    @Override
    public String toString(){
        return "Class name: ExecuteScript" + " - / " + new Date().toString() + " /";
    }
}
