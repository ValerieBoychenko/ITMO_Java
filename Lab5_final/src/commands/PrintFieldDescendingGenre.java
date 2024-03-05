package commands;

import java.util.Date;

/**
 * Команда для печати жанров музыкальных групп в порядке убывания.
 */
public class PrintFieldDescendingGenre extends Command {
    /**
     * Печатает жанры музыкальных групп в порядке убывания.
     * Если жанр равен null, генерируется исключение NullPointerException.
     */
    public void printFieldDescendingGenre() {

        var newMusicBands = musicBands.getMusicBands();
        newMusicBands.descendingMap().forEach((key, value) -> {
            if (value != null) {
                System.out.println(value.getGenre());
            } else {
                throw new NullPointerException("Genre is null for music band. \n" + this.toString());
            }
        });
        musicBands.updateCollection(newMusicBands);
    }
    /**
     * Переопределенный метод toString для представления объекта в виде строки.
     * Возвращает строку с названием класса, текущей датой и временем.
     *
     * @return Строка, представляющая объект в виде "Class name: PrintFieldDescendingGenre - / [текущая дата и время] /".
     */
    @Override
    public String toString(){
        return "Class name: PrintFieldDescendingGenre" + " - / " + new Date().toString() + " /";
    }

}
