package commands;

import parameters.CommandValidator;
import parameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class ReplaceIfGreater extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 14L;

    public void executeReadParameters(){parameter = CommandValidator.Validation(TypeParameter.KEY_AND_MUSIC_BAND);}
}
