package commands;

import commands.auxiliaryCommands.CommandValidator;
import commands.commandParameters.TypeParameter;

import java.io.Serial;
import java.io.Serializable;


public class RemoveKey extends Command implements Serializable {
    @Serial
    private static final long serialVersionUID = 12L;

    public void executeReadParameters(){
        parameter = CommandValidator.Validation(TypeParameter.KEY);
    }
}
