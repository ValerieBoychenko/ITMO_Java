package commands;

import models.MusicBand;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RemoveGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 11L;

    public String execute() throws NullPointerException {
        String result = "";
        try {
            TreeMap<Integer, MusicBand> newMusicBands = musicBands.getMusicBands();
            newMusicBands.keySet().removeIf(k -> {
                if (k == null) {
                    throw new NullPointerException("Key in the map cannot be null");
                }
                return k > Integer.parseInt(parameter.getParameter());
            });
            musicBands.updateCollection(newMusicBands);
            result = newMusicBands.keySet().stream()
                    .map(newKey -> "Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> " + newKey)
                    .collect(Collectors.joining("\n"));
            return result;
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
        return "Command execution error!";
    }

    @Override
    public String toString(){
        return "Class name: RemoveGreater" + " - / " + new Date().toString() + " /";
    }

}
