package commands.auxiliaryCommands;

import commands.Command;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


public class InfoAboutKeyCollection extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 17L;
    public String execute(){
        String info = "";
        if (musicBands.getMusicBands().isEmpty()){
            return "The collection is empty!";
        }
        for (Integer key : musicBands.getMusicBands().keySet()){
            info += "Name: " + musicBands.getMusicBands().get(key).getName() + " -> "  + key + "\n";
        }
        return info;
    }

    @Override
    public String toString(){
        return "Class name: InfoAboutKeyCollection" + " - / " + new Date().toString() + " /";
    }
}
