package commands;

import commands.auxiliaryCommands.CommandValidator;
import commands.commandParameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;

public class Exit extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 5L;

    public void executeReadParameters(){parameter = CommandValidator.Validation(TypeParameter.NONE);}
}
