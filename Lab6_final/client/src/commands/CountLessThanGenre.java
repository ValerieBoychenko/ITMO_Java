package commands;


import commands.auxiliaryCommands.CommandValidator;
import commands.commandParameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class CountLessThanGenre extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 3L;

    public void executeReadParameters() {parameter = CommandValidator.Validation(TypeParameter.GENRE);}
}

