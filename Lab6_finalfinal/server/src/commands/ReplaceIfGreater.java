package commands;

import models.MusicBand;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class ReplaceIfGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 14L;

    public String execute() {
        try {
            if (parameter.getMusicBand() == null) {
                throw new NullPointerException("musicBand is not initialized.\n" + this.toString());
            }
            MusicBand oldValue = musicBands.getMusicBands().get(Integer.parseInt(parameter.getParameter()));
            if (oldValue != null) {
                if (parameter.getMusicBand().compareTo(oldValue) > 0) {
                    musicBands.put(Integer.parseInt(parameter.getParameter()), (parameter.getMusicBand()));
                } else {
                    return "oldValue greater then newValue.";
                }
            } else {
                throw new NullPointerException("oldValue is not initialized.\n" + this.toString());
            }
            String result = "";
            result = musicBands.getMusicBands().keySet().stream()
                    .map(newKey -> "Name: " + musicBands.getMusicBands().get(newKey).getName() + " -> " + newKey)
                    .collect(Collectors.joining("\n"));
            return result;

        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
        return "Command execution error!";
    }

    @Override
    public String toString() {
        return "Class name: ReplaceIfGreater" + " - / " + new Date().toString() + " /";
    }

}
