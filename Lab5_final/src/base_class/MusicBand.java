package base_class;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс, представляющий музыкальную группу.
 */
public class MusicBand implements Comparable<MusicBand>, Serializable {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private int numberOfParticipants;
    private long albumsCount;
    private Date establishmentDate;
    private MusicGenre genre;
    private Label label;

    /**
     * Конструктор для создания объекта base_class.MusicBand.
     *
     * @param name                 название группы
     * @param coordinates          координаты местоположения группы
     * @param numberOfParticipants количество участников группы
     * @param albumsCount          количество альбомов группы
     * @param establishmentDate    дата создания группы
     * @param genre                музыкальный жанр группы
     * @param label                лейбл, к которому принадлежит группа
     * @throws NullPointerException     если один из аргументов равен null
     * @throws IllegalArgumentException если количество участников или количество альбомов меньше или равно 0
     */
    public MusicBand(String name, Coordinates coordinates, int numberOfParticipants, long albumsCount, java.util.Date establishmentDate, MusicGenre genre, Label label) {
        this.id = new Random().nextLong();
        this.name = Objects.requireNonNull(name, "Field cannot be null");
        this.coordinates = Objects.requireNonNull(coordinates, "Field cannot be null");
        this.creationDate = Objects.requireNonNull(ZonedDateTime.now(), "Error");
        this.numberOfParticipants = checkPositive(numberOfParticipants);
        this.albumsCount = checkPositive(albumsCount);
        this.establishmentDate = Objects.requireNonNull(establishmentDate, "Field cannot be null");
        this.genre = Objects.requireNonNull(genre, "Field cannot be null");
        this.label = Objects.requireNonNull(label, "Field cannot be null");
    }
    public MusicBand(){}

    /**
     * Проверяет, является ли число положительным.
     *
     * @param number число для проверки
     * @return переданное число, если оно положительное
     * @throws IllegalArgumentException если переданное число меньше или равно 0
     */
    public static int checkPositive(int number) throws IllegalArgumentException {
        if (number > 0) {
            return number;
        } else {
            throw new IllegalArgumentException("Число не является положительным: " + number);
        }
    }

    /**
     * Проверяет, является ли число положительным.
     *
     * @param number число для проверки
     * @return переданное число, если оно положительное
     * @throws IllegalArgumentException если переданное число меньше или равно 0
     */
    public static long checkPositive(long number) throws IllegalArgumentException {
        if (number > 0) {
            return number;
        } else {
            throw new IllegalArgumentException("Число не является положительным: " + number);
        }
    }

    /**
     * Сравнивает данную группу с другой группой на основе их названий.
     *
     * @param other другая группа для сравнения
     * @return отрицательное целое число, ноль или положительное целое число в зависимости от того, является ли данная группа
     * лексикографически меньше, равной или больше другой группы
     */
    @Override
    public int compareTo(MusicBand other) { // сортирует коллекцию по умолчанию
        return this.name.compareTo(other.name);
    }

    /**
     * Возвращает строковое представление объекта base_class.MusicBand.
     *
     * @return строковое представление объекта base_class.MusicBand
     */
    @Override
    public String toString() {
        return "base_class.MusicBand {" + "\n" +
                "id =" + id + "\n" +
                "name = " + name + "\n" +
                "coordinates =" + coordinates + "\n" +
                "creationDate =" + creationDate + "\n" +
                "numberOfParticipants =" + numberOfParticipants + "\n" +
                "albumsCount =" + albumsCount + "\n" +
                "establishmentDate =" + establishmentDate + "\n" +
                "genre =" + genre + "\n" +
                "label =" + label + "\n" +
                '}';
    }

    /**
     * Возвращает уникальный идентификатор группы.
     *
     * @return уникальный идентификатор группы
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает новую группу.
     *
     * @return новая группа
     */
    public MusicBand createNewMusicBand(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter new element:");

        System.out.println("----- Enter name: ");
        String name = in.nextLine();

        System.out.println("----- Enter Coordinates: ");
        Float x = in.nextFloat();
        Integer y = in.nextInt();
        var coordinates = new Coordinates(x, y);

        System.out.println("----- Enter numberOfParticipants: ");
        int numberOfParticipants = in.nextInt();

        System.out.println("----- Enter albumsCount: ");
        long albumsCount = in.nextLong();

        System.out.println("----- Enter establishmentDate: ");
        String establishmentDateString = in.nextLine();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(establishmentDateString, DateTimeFormatter.ISO_DATE_TIME);
        Date establishmentDate = Date.from(zonedDateTime.toInstant());

        System.out.println("----- Enter genre: ");
        String genre = in.nextLine();

        System.out.println("----- Enter label: ");
        Long bands = in.nextLong();
        var label = new Label(bands);

        return new MusicBand(name, coordinates, numberOfParticipants, albumsCount, establishmentDate, MusicGenre.convert(genre), label);
    }
    /**
     * Возвращает название группы.
     *
     * @return название группы
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает координаты местоположения группы.
     *
     * @return координаты местоположения группы
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Возвращает дату и время создания записи о группе.
     *
     * @return дата и время создания записи о группе
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Возвращает количество участников группы.
     *
     * @return количество участников группы
     */
    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Возвращает количество альбомов группы.
     *
     * @return количество альбомов группы
     */
    public long getAlbumsCount() {
        return albumsCount;
    }

    /**
     * Возвращает дату создания группы.
     *
     * @return дата создания группы
     */
    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    /**
     * Возвращает музыкальный жанр группы.
     *
     * @return музыкальный жанр группы
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Возвращает лейбл, к которому принадлежит группа.
     *
     * @return лейбл, к которому принадлежит группа
     */
    public Label getLabel() {
        return label;
    }
}