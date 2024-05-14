package commands;

import parameters.ParametersRequest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;
public class InsertNewElement extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 9L;

    public String execute() throws NullPointerException {
        try {
            if (musicBands == null) {
                throw new NullPointerException("MusicBands is not initialized.\n" + this.toString());
            }
            if (!musicBands.getMusicBands().containsKey(Integer.parseInt(parameter.getParameter()))) {
                musicBands.put(Integer.parseInt(parameter.getParameter()), parameter.getMusicBand());
                return "The item was added successfully";
            }else {
                return "This key is busy, please try again.";
            }
        } catch (InputMismatchException e) {
            System.out.println("Ключ введен неверно!" + "\n" + new InsertNewElement().toString());
        }
        return "Command execution error!";
    }

    @Override
    public String toString(){
        return "Имя класса: InsertNewElement" + " - / " + new Date().toString() + " /";
    }
}

