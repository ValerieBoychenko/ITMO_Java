package handlers;

import base_class.MusicGenre;

import java.util.Objects;

/**
 * Класс, отвечающий за конвертацию строковых значений в перечисление MusicGenre.
 */
public class Converter {
    /**
     * Метод, конвертирующий строковое значение в соответствующее перечисление MusicGenre.
     * @param genre строковое значение жанра музыки
     * @return соответствующее перечисление MusicGenre
     */
    public MusicGenre convert(String genre){
        if (Objects.equals(genre, "ROCK")){
            return MusicGenre.ROCK;
        }
        if (Objects.equals(genre, "BLUES")){
            return MusicGenre.BLUES;
        }
        if (Objects.equals(genre, "POP")){

            return MusicGenre.POP;
        }
        if (Objects.equals(genre, "POST_ROCK")){
            return MusicGenre.POST_ROCK;
        }
        if (Objects.equals(genre, "BRIT_POP")){
            return MusicGenre.BRIT_POP;
        }
        return null;
    }
}
