package commands;

import commands.commandParameters.MusicBandAndKeyParameters;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;

public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;

    public String execute() {
        try {
            if (((MusicBandAndKeyParameters) parameter).musicBand() == null) {
                throw new NullPointerException("newMusicBand is not initialized.\n" + this.toString());
            }
            if (musicBands.getMusicBands().containsKey(Integer.parseInt(((MusicBandAndKeyParameters) parameter).key()))) {
                musicBands.put(Integer.parseInt(((MusicBandAndKeyParameters) parameter).key()), ((MusicBandAndKeyParameters) parameter).musicBand());
                return "An element with a key " + ((MusicBandAndKeyParameters) parameter).key() + " successfully updated.";
            } else {
                return "An element with a key " + ((MusicBandAndKeyParameters) parameter).key() + " not found in the collection.";
            }
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
        return "Command execution error!";
    }

    @Override
    public String toString(){
        return "Class name: Update" + " - / " + new Date().toString() + " /";
    }

}
