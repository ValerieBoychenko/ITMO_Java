package commands;

import parser.ManualInput;

import java.io.Serial;
import java.io.Serializable;


public class RemoveLowerKey extends Command implements Serializable {
    private String key;
    @Serial
    private static final long serialVersionUID = 13L;
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
