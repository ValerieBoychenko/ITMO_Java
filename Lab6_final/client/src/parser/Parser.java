package parser;

import commands.*;
import commands.auxiliaryCommands.InfoAboutKeyCollection;
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
        return switch (command.split(" ")[0]) {
            case "keys" -> new InfoAboutKeyCollection();
            case "help" -> new Help();
            case "info" -> new Info();
            case "show" -> new Show();
            case "insert" -> new InsertNewElement();
            case "update" -> new Update();
            case "remove_key" -> new RemoveKey();
            case "clear" -> new Clear();
            case "execute_script" -> new ExecuteScript(command.split(" ")[1]);
            case "exit" -> new Exit();
            case "remove_greater" -> new RemoveGreater();
            case "replace_if_greater" -> new ReplaceIfGreater();
            case "remove_lower_key" -> new RemoveLowerKey();
            case "count_less_than_genre" -> new CountLessThanGenre();
            case "filter_starts_with_name" -> new FilterStartsWithName();
            case "print_field_descending_genre" -> new PrintFieldDescendingGenre();
            default -> null;
        };
    }
}

