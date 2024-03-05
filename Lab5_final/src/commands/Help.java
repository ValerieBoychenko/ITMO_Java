package commands;

import exception.ConsoleOutputErrorException;

import java.util.Date;


/**
 * Класс Help предоставляет функционал для вывода справочной информации о доступных командах.
 */
public class Help extends Command {

    /**
     * Выводит справочную информацию о доступных командах в стандартный поток вывода.
     * @throws ConsoleOutputErrorException если произошла ошибка вывода данных в консоль.
     */
    public void help() throws ConsoleOutputErrorException {
        try {
            // Вывод справочной информации о командах {
            System.out.println("help - output help for available commands");
            System.out.println("info - output information about the collection (type, initialization date, number of items, etc.) to the standard output stream.");
            System.out.println("show - output all the elements of the collection in a string representation to the standard output stream");
            System.out.println("insert null - add a new element with the specified key");
            System.out.println("update id - update the value of a collection item whose id is equal to the specified one");
            System.out.println("remove_key null - delete an item from the collection by its key");
            System.out.println("clear - clear the collection");
            System.out.println("save  - save the collection to a file");
            System.out.println("execute_script file_name - read and execute the script from the specified file. The script contains commands in the same form as they are entered by the user interactively.");
            System.out.println("exit - end the program (without saving to a file)");
            System.out.println("remove_greater - remove all items from the collection that exceed the specified limit");
            System.out.println("replace_if_greater null - replace the value by key if the new value is greater than the old one");
            System.out.println("remove_lower_key null - remove all items from the collection whose key is less than the specified one");
            System.out.println("count_less_than_genre genre - print the number of elements whose genre field value is less than the specified one");
            System.out.println("filter_starts_with_name name - print the elements whose name field value starts with the specified substring");
            System.out.println("print_field_descending_genre - print the values of the genre field of all elements in descending order");
        } catch (Exception e) {
            // Если произошла ошибка, выбрасываем исключение
            throw new ConsoleOutputErrorException("Ошибка вывода данных в консоль" + this.toString());
        }
    }

    @Override
    public String toString(){
        // Возвращаем строковое представление класса с указанием времени
        return "Имя класса: Help" + " - / " + new Date().toString() + " /";
    }
}