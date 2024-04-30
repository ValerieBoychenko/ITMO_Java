package commands;

import java.io.Serial;
import java.io.Serializable;

import static java.lang.System.exit;

public class Exit extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    public String execute(){
        new Save().execute();
        exit(1);
        return null;
    }
}
