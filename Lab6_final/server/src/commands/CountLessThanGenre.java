package commands;

import baseClass.MusicGenre;
import commands.commandParameters.StringParameters;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class CountLessThanGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    public String execute() throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
        }
        long count = musicBands.getMusicBands().values().stream()
                .filter(band -> band.getGenre().compareTo(Objects.requireNonNull(MusicGenre.convert(((StringParameters) parameter).parameter()))) < 0)
                .count();
        return String.valueOf(count);
    }

    @Override
    public String toString(){
        return "Class name: CountLessThanGenre" + " - / " + new Date().toString() + " /";
    }

}

