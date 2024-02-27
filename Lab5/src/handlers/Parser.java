package handlers;

import java.util.Objects;
import java.util.Scanner;

public class Parser {

    private String command;
    private final Action action = new Action();
    private boolean flag = true;
    public void start(){
        while (flag) {
            System.out.println("Enter the command: \n");
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
            if (Objects.equals(command.split(" ")[0], "help")) {
                action.help();
            }
            if (Objects.equals(command.split(" ")[0], "info")) {
                action.info();
            }
            if (Objects.equals(command.split(" ")[0], "show")) {
                action.show();
            }
            if (Objects.equals(command.split(" ")[0], "insert")) {
                action.insert();
            }
            if (Objects.equals(command.split(" ")[0], "update")) {
                action.update();
            }
            if (Objects.equals(command.split(" ")[0], "remove_key")) {
                action.remove();
            }
            if (Objects.equals(command.split(" ")[0], "clear")) {
                action.clear();
            }
            if (Objects.equals(command.split(" ")[0], "save")) {
                action.save();
            }
            if (Objects.equals(command.split(" ")[0], "execute_script")) {
                action.executeScript();
            }
            if (Objects.equals(command.split(" ")[0], "exit")) {
                flag = false;
            }
            if (Objects.equals(command.split(" ")[0], "remove_greater")) {
                action.removeGreater();
            }
            if (Objects.equals(command.split(" ")[0], "replace_if_greater")) {
                action.replaceIfGreater();
            }
            if (Objects.equals(command.split(" ")[0], "remove_lower_key")) {
                action.removeLowerKey();
            }
            if (Objects.equals(command.split(" ")[0], "count_less_than_genre")) {
                action.countLessThanGenreElement();
            }
            if (Objects.equals(command.split(" ")[0], "filter_starts_with_name")) {
                action.filterStartsWithName();
            }
            if (Objects.equals(command.split(" ")[0], "print_field_descending_genre")) {
                action.printFieldDescendingGenre();
            }
        }
    }
}
