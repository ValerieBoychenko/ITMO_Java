package handlers;

import base_class.MusicBand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс, представляющий обработчик действий пользователя.
 */
public class Action {
    private MusicBandManager musicBandManager = new MusicBandManager();

    /**
     * Конструктор класса. Загружает данные из файла при создании экземпляра класса.
     */
    public Action(){
        musicBandManager.loadDataFromFile("/Users/valeriabojcenko/Desktop/Lab5/src/input_output_file/data.json");
    }

    /**
     * Выводит справку по доступным командам.
     */
    public void help(){
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

    }
    /**
     * Выводит информацию о коллекции.
     */
    public void info(){
        System.out.println("Information about the music Bands collection:");
        System.out.println("Тип коллекции: TreeMap<String, base_class.MusicBand>");
        System.out.println("Type of collection: " + musicBandManager.getInitializationDate());
        System.out.println("Number of elements: " + musicBandManager.getMusicBands().size());
    }

    /**
     * Выводит все элементы коллекции.
     */
    public void show(){
        var bands = musicBandManager.getMusicBands();
        for (Integer key : bands.keySet()) {
            MusicBand band = musicBandManager.getMusicBands().get(key);
            System.out.println(band.toString());
        }
    }
    /**
     * Добавить новый элемент с заданным ключом
     */
    public void insert(){
        System.out.println("Enter new key");
        Scanner in = new Scanner(System.in);
        Integer key = in.nextInt();
        var newMusicBand = new MusicBand().createNewMusicBand();
        musicBandManager.insertNewElement(key, newMusicBand);
    }

    /**
     * Обновить значение элемента коллекции, id которого равен заданному
     */
    public void update(){
        System.out.println("Enter key: ");
        Scanner in = new Scanner(System.in);
        Integer key = in.nextInt();
        var newMusicBand = new MusicBand().createNewMusicBand();
        musicBandManager.updateElement(key, newMusicBand);
    }

    /**
     * Удалить элемент из коллекции по его ключу
     */
    public void remove(){
        System.out.println("Enter key: ");
        Scanner in = new Scanner(System.in);
        Integer key = in.nextInt();
        musicBandManager.removeElement(key);
    }

    /**
     * Очистить коллекцию
     */
    public void clear(){
        musicBandManager.clearAllElement();
    }

    /**
     * Сохранить коллекцию в файл
     */
    public void save(){
        System.out.println("Enter fileName: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        musicBandManager.writingToFile(fileName);
    }

    /**
     * Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в
     * таком же виде, в котором их вводит пользователь в интерактивном режиме.
     *
     */
    public void executeScript(){
        System.out.println("Enter fileName: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String command;
            while ((command = br.readLine()) != null) {
                if (Objects.equals(command.split(" ")[0], "help")) {
                    help();
                }
                if (Objects.equals(command.split(" ")[0], "info")) {
                    info();
                }
                if (Objects.equals(command.split(" ")[0], "show")) {
                    show();
                }
                if (Objects.equals(command.split(" ")[0], "insert")) {
                    insert();
                }
                if (Objects.equals(command.split(" ")[0], "update")) {
                    update();
                }
                if (Objects.equals(command.split(" ")[0], "remove_key")) {
                    remove();
                }
                if (Objects.equals(command.split(" ")[0], "clear")) {
                    clear();
                }
                if (Objects.equals(command.split(" ")[0], "save")) {
                    save();
                }
                if (Objects.equals(command.split(" ")[0], "exit")) {
                    break;
                }
                if (Objects.equals(command.split(" ")[0], "remove_greater")) {
                    removeGreater();
                }
                if (Objects.equals(command.split(" ")[0], "replace_if_greater")) {
                    removeGreater();
                }
                if (Objects.equals(command.split(" ")[0], "remove_lower_key")) {
                    removeLowerKey();
                }
                if (Objects.equals(command.split(" ")[0], "count_less_than_genre")) {

                }
                if (Objects.equals(command.split(" ")[0], "filter_starts_with_name")) {

                }
                if (Objects.equals(command.split(" ")[0], "print_field_descending_genre")) {

                }
                if (Objects.equals(command.split(" ")[0], "remove_lower_key")) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Удалить из коллекции все элементы, превышающие заданный
     */
     public void removeGreater(){
         System.out.println("Enter key: ");
         Scanner in = new Scanner(System.in);
         Integer fileName = in.nextInt();
         musicBandManager.removeGreaterElement(fileName);
     }

    /**
     * Заменить значение по ключу, если новое значение больше старого
     */
     public void replaceIfGreater() {
         System.out.println("Enter key: ");
         Scanner in = new Scanner(System.in);
         Integer key = in.nextInt();
         var musicBand = new MusicBand().createNewMusicBand();
         musicBandManager.replaceIfGreaterElement(key, musicBand);
     }

    /**
     * Удалить из коллекции все элементы, ключ которых меньше, чем заданный
     */
    public void removeLowerKey(){
        System.out.println("Enter key: ");
        Scanner in = new Scanner(System.in);
        Integer key = in.nextInt();
        musicBandManager.removeLowerKeyElement(key);
    }

    /**
     * Вывести количество элементов, значение поля genre которых меньше заданного
     */
    public void countLessThanGenreElement(){
        System.out.println("Enter genre: ");
        Scanner in = new Scanner(System.in);
        String genre = in.nextLine();
        System.out.println(musicBandManager.countLessThanGenreElement(new Converter().convert(genre)));
    }

    /**
     * Вывести элементы, значение поля name которых начинается с заданной подстроки
     */
    public void filterStartsWithName(){
        System.out.println("Enter name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        List<MusicBand> bands = musicBandManager.filterStartsWithName(name);
        for (MusicBand band : bands){
            System.out.println(band.toString());
        }
    }

    /**
     * Вывести значения поля genre всех элементов в порядке убывания
     */
    public void printFieldDescendingGenre(){
        musicBandManager.printFieldDescendingGenre();
    }
}
