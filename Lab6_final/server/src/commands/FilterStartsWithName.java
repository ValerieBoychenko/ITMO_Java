package commands;

import baseClass.MusicBand;
import commands.commandParameters.StringParameters;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FilterStartsWithName extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 6L;

    public String execute() throws NullPointerException {
        try {
            String result = "";
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this);
            }
            List<MusicBand> filteredBands = musicBands.getMusicBands().values().stream()
                    .filter(band -> band.getName().startsWith(((StringParameters) parameter).parameter()))
                    .toList();
            if (filteredBands.isEmpty()) {
                return "There are no such groups.";

            } else {
                result = filteredBands.stream()
                        .map(MusicBand::toString)
                        .collect(Collectors.joining("\n"));
            }
            return result;
        } catch (InputMismatchException e) {
            System.out.println("The name was entered incorrectly!");
        }
        return "Command execution error!";
    }

    @Override
    public String toString() {
        return "Class name: FilterStartsWithName" + " - / " + new Date().toString() + " /";
    }

}

