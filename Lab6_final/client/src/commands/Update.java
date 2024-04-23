package commands;



import base_class.MusicBand;
import parser.ManualInput;

import java.io.Serial;
import java.io.Serializable;


public class Update extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;
    String key;

    MusicBand musicBand;
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
        this.musicBand = new MusicBand().createNewMusicBand();
    }
}
