package parser;

import commands.*;
import commands.auxiliaryCommands.InfoAboutKeyCollection;
import commands.specialCommands.ExecuteScript;
import exceptions.ConsoleOutputErrorException;
import interfaces.Reader;

public class Parser {
    private final Reader scanner;
    private String command;
    private boolean flag = true;

    public Parser(){
        this.scanner = new ManualInput();
    }
    public Command start(){
        try {
            System.out.println("Enter the command:");
            command = scanner.nextLine();
            return parsing(command);
        } catch (ConsoleOutputErrorException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Command parsing(String command) throws ConsoleOutputErrorException {
        switch (command.split(" ")[0]) {
            case "keys":
                return new InfoAboutKeyCollection();
            case "help":
                return new Help();
            case "info":
                return new Info();
            case "show":
                return new Show();
            case "insert":
                return new InsertNewElement();
            case "update":
                return new Update();
            case "remove_key":
                return new RemoveKey();
            case "clear":
                return new Clear();
            case "execute_script":
                if (command.split(" ").length > 1){
                    return new ExecuteScript(command.split(" ")[1]);
                }else {
                    System.out.println("The command was entered incorrectly");
                    System.out.println("Please enter the command: execute_script _____path_____");
                }
                return null;
            case "exit":
                return new Exit();
            case "remove_greater":
                return new RemoveGreater();
            case "replace_if_greater":
                return new ReplaceIfGreater();
            case "remove_lower_key":
                return new RemoveLowerKey();
            case "count_less_than_genre":
                return new CountLessThanGenre();
            case "filter_starts_with_name":
                return new FilterStartsWithName();
            case "print_field_descending_genre":
                return new PrintFieldDescendingGenre();
            default:
                return null;
        }
    }
}

