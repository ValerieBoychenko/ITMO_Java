package handlers;

import commands.*;
import exception.ConsoleOutputErrorException;
import workingWithFile.Reader;
import workingWithFile.Writer;

import java.util.Scanner;
/**
 * Класс Parser предназначен для обработки команд пользователя.
 * Принимает команды от пользователя, выполняет соответствующие действия и выводит результаты.
 */
public class Parser {
    /**
     * Конструктор класса.
     *
     * @param fileName имя файла
     */
    public Parser(String fileName){
        this.fileName = fileName;
    }
    private String fileName;

    private String command;
    private boolean flag = true;
    /**
     * Метод для запуска парсера и обработки команд пользователя.
     * Выводит приглашение для ввода команды, считывает введенную команду и выполняет соответствующее действие.
     * При возникновении исключений типа ConsoleOutputErrorException или NullPointerException,
     * выводит сообщение об ошибке в консоль.
     */
    public void start(){
        while (flag) {
            try {
                System.out.println("Enter the command: \n");
                Scanner in = new Scanner(System.in);
                command = in.nextLine();
                parsing(command);
            } catch (ConsoleOutputErrorException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void parsing(String command) throws ConsoleOutputErrorException {
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
                new Save().save(fileName);
                break;
            case "execute_script":
                new ExecuteScript().executeScript();
                break;
            case "exit":
                flag = false;
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
            case "read":
                new Reader().read(fileName);
                break;
            case "write":
                new Writer().writing(fileName);
        }
    }
}

