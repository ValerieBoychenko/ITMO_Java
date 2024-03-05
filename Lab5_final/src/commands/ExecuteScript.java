package commands;

import exception.CommandException;
import exception.ConsoleOutputErrorException;

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
        System.out.println("Enter fileName: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String command;
            while ((command = br.readLine()) != null) {
                switch (command.split(" ")[0]) {
                    case "help":
                        new Help().help();
                        break;
                    case "info":
                        new Info().info();
                        break;
                    case "show":
                        new Show().show();
                        break;
                    case "insert":
                        new InsertNewElement().insertNewElement();
                        break;
                    case "update":
                        new Update().update();
                        break;
                    case "remove_key":
                        new RemoveKey().remove();
                        break;
                    case "clear":
                        new Clear().clear();
                        break;
                    case "save":
                        new Save().save();
                        break;
                    case "execute_script":
                        new ExecuteScript().executeScript();
                        break;
                    case "exit":
                        break;
                    case "remove_greater":
                        new RemoveGreater().removeGreater();
                        break;
                    case "replace_if_greater":
                        new ReplaceIfGreater().replaceIfGreater();
                        break;
                    case "remove_lower_key":
                        new RemoveLowerKey().removeLowerKey();
                        break;
                    case "count_less_than_genre":
                        new CountLessThanGenre().countLessThanGenre();
                        break;
                    case "filter_starts_with_name":
                        new FilterStartsWithName().filterStartsWithName();
                        break;
                    case "print_field_descending_genre":
                        new PrintFieldDescendingGenre().printFieldDescendingGenre();
                        break;
                }
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
