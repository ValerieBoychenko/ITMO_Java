package commands;

import base_class.MusicBand;

import java.util.*;

/**
 * Класс для фильтрации музыкальных групп по имени, начинающемуся с определенной строки.
 */
public class FilterStartsWithName extends Command {

    /**
     * Метод для фильтрации музыкальных групп по имени, начинающемуся с определенной строки.
     * @throws NullPointerException если musicBands не инициализирован
     */
    public void filterStartsWithName() throws NullPointerException {
        try {
            System.out.println("Enter name: ");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();
            List<MusicBand> filteredBands = new ArrayList<>();
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            for (MusicBand band : musicBands.getMusicBands().values()) {
                if (band.getName().startsWith(name)) {
                    filteredBands.add(band);
                }
            }
            if (filteredBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            for (MusicBand band : filteredBands) {
                System.out.println(band.toString());
            }
        } catch (InputMismatchException e) {
            System.out.println("The name was entered incorrectly!");
        }
    }

    /**
     * Переопределение метода toString для класса.
     * @return строка, представляющая объект класса FilterStartsWithName
     */
    @Override
    public String toString() {
        return "Class name: FilterStartsWithName" + " - / " + new Date().toString() + " /";
    }

}

