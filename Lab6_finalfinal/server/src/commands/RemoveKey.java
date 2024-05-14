package commands;

import commands.auxiliaryCommands.CheckCorrectKey;
import parameters.ParametersRequest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.InputMismatchException;

public class RemoveKey extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 12L;

    public String execute() {
        try {
            int correctKey = CheckCorrectKey.checking(Integer.parseInt(parameter.getParameter()));
            if (correctKey != -1){
                musicBands.remove(correctKey);
                return "The operation was completed successfully";
            }
        } catch (ClassCastException e) {
            System.out.println("Key not exist");
        } catch (InputMismatchException e) {
            System.out.println("The key was entered incorrectly!");
        }
        return "Command execution error!";
    }

    @Override
    public String toString(){
        return "Class name: RemoveKey" + " - / " + new Date().toString() + " /";
    }
}
