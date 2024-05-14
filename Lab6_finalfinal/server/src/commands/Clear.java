package commands;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.TreeMap;

public class Clear extends Command implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String execute() throws NullPointerException {
        if (musicBands == null) {
            throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
        }
        musicBands.updateCollection(new TreeMap<>());
        return "The collection has been successfully cleared.";
    }

    @Override
    public String toString(){
        return "Class name: Clear" + " - / " + new Date().toString() + " /";
    }

}
