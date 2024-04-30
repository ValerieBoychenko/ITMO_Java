package commands;

import baseClass.MusicBand;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

public class Show extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 16L;

    public String execute() {

        var bands = musicBands.getMusicBands();
        if (bands == null) {
            throw new NullPointerException("Bands is not initialized.\n" + this.toString());
        }
        if (musicBands.getMusicBands().isEmpty()){
            return "The collection is empty!";
        }
        String result = bands.values().stream()
                .sorted(Comparator.comparing(MusicBand::getName))
                .map(MusicBand::toString)
                .collect(Collectors.joining("\n"));
        return result;
    }

    @Override
    public String toString(){
        return "Class name: Show" + " - / " + new Date().toString() + " /";
    }

}
