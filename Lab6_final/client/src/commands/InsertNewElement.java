package commands;

import commands.auxiliaryCommands.CommandValidator;
import commands.commandParameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public class InsertNewElement extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 9L;

    public void executeReadParameters(){parameter = CommandValidator.Validation(TypeParameter.KEY_AND_MUSIC_BAND);}
}

