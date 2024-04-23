package commands;

import parser.ManualInput;

import java.io.Serial;
import java.io.Serializable;



public class RemoveKey extends Command implements Serializable {

    @Serial
    private static final long serialVersionUID = 12L;

    private String key;


    public void executeReadParameters(){
        System.out.println("Enter key: ");
        String currentKey = new ManualInput().nextLine();
        try {
            Integer.parseInt(currentKey);
            this.key = currentKey;
        } catch (NumberFormatException e) {
            System.out.println("Invalid key. Please enter a valid integer key.");
            executeReadParameters();
        }
    }
}
