package commands;

import parameters.ParametersRequest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;

public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;

    public String execute() {
        try {
            if (parameter.getMusicBand() == null) {
                throw new NullPointerException("newMusicBand is not initialized.\n" + this.toString());
            }
            if (musicBands.getMusicBands().containsKey(Integer.parseInt(parameter.getParameter()))) {
                musicBands.put(Integer.parseInt(parameter.getParameter()), parameter.getMusicBand());
                return "An element with a key " + parameter.getParameter() + " successfully updated.";
            } else {
                return "An element with a key " + parameter.getParameter() + " not found in the collection.";
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
